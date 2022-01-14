package com.liudi.im;

import cn.hutool.core.util.StrUtil;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.liudi.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * 
 **/
@ServerEndpoint(value = "/websocket")
@Component
public class MyWebSocket {
    private static final Logger logger = LoggerFactory.getLogger(MyWebSocket.class);

    //静态变量，用来记录当前在线连接数。应该把它设计成线程安全的。
    private static int onlineCount = 0;

    //与某个客户端的连接会话，需要通过它来给客户端发送数据
    private Session session;

    //用以记录用户和房间号的对应关系(sessionId,room)
    private static HashMap<String,String> RoomForUser = new HashMap<String,String>();

    //用以记录房间和其中用户群的对应关系(room,List<用户>)
    public static HashMap<String,CopyOnWriteArraySet<User>> UserForRoom = new HashMap<String,CopyOnWriteArraySet<User>>();

    //用以记录房间和其中用户群的对应关系(room,List<用户>)
    public static HashMap<String,String> PwdForRoom = new HashMap<String,String>();

    //用来存放必应壁纸
    public static List<String> BingImages = new ArrayList<>();

    private Gson gson = new Gson();

    private Random random = new Random();

    /**
     * 连接建立成功调用的方法
     * @param session
     */
    @OnOpen
    public void onOpen(Session session) throws IOException {
        logger.debug("---------------------成功与{}建立连接---------------------",session.getId());
        this.session = session;
        addOnlineCount();
        Map<String,String> result = new HashMap<>();
        result.put("type","bing");
        result.put("msg",BingImages.get(random.nextInt(BingImages.size()))); // 这个msg是干嘛用的？第一次加载壁纸用的，毛包，没卵用
        result.put("sendUser","系统消息");
        result.put("id",session.getId());
        this.sendMessage(gson.toJson(result));
    }

    /**
     * 连接关闭调用的方法
     */
    @OnClose
    public void onClose() {
        subOnlineCount();
        CopyOnWriteArraySet<User> users = getUsers(session);
        if (users!=null){
            String nick = "某人";
            for (User user : users) {
                if (user.getId().equals(session.getId())){
                    nick = user.getNickname();
                }
            }
            Map<String,String> result = new HashMap<>();
            result.put("type","init");
            result.put("msg",nick+"离开房间");
            result.put("sendUser","系统消息");
            sendMessagesOther(users,gson.toJson(result));
            User closeUser = getUser(session);
            users.remove(closeUser);
            if (users.size() == 0){
                String room = RoomForUser.get(session.getId());
                UserForRoom.remove(room);
                PwdForRoom.remove(room);
            }
            RoomForUser.remove(session.getId());
        }
    }

    /**
     * 收到客户端消息后调用的方法
     * @param message 消息内容
     * @param session
     */
    @OnMessage
    public void onMessage(String message, Session session) {
        Map<String,String> map = new Gson().fromJson(message, new TypeToken<HashMap<String,String>>(){}.getType());
        Map<String,String> result = new HashMap<>();
        User user = null;
        String shiels = map.containsKey("shiels")?map.get("shiels").toString():null;
        switch (map.get("type")){
            case "msg" :
                user = getUser(session);
                result.put("type","msg");
                result.put("msg",map.get("msg"));
                result.put("sendUser",user.getNickname());
                result.put("shake",map.get("shake"));
                break;
            case "init":
                String room = map.get("room");
                String nick = map.get("nick");
                String pwd = map.get("pwd");
                if (room != null && nick != null){
                    user = new User(session.getId(),nick,this);
                    //如果房间不存在，新建房间
                    if (UserForRoom.get(room) == null){
                        CopyOnWriteArraySet<User> roomUsers = new CopyOnWriteArraySet<>();
                        roomUsers.add(user);
                        UserForRoom.put(room,roomUsers);
                        if (StrUtil.isNotEmpty(pwd)){
                            PwdForRoom.put(room,pwd);
                        }
                        RoomForUser.put(session.getId(),room);
                    }else {
                        UserForRoom.get(room).add(user);
                        RoomForUser.put(session.getId(),room);
                    }
                    result.put("type","init");
                    result.put("msg",nick+"成功加入房间");
                    result.put("sendUser","系统消息");
                }
                break;
            case "img":
                user = getUser(session);
                result.put("type","img");
                result.put("msg",map.get("msg"));
                result.put("sendUser",user.getNickname());
                break;
            case "ping":
                return;
        }
        if (StrUtil.isEmpty(shiels)){
            sendMessagesOther(getUsers(session),gson.toJson(result));
        }else {
            sendMessagesOther(getUsers(session),gson.toJson(result),shiels);
        }
    }

    /**
     * 连接发生错误时的调用方法
     * @param session
     * @param error
     */
    @OnError
    public void onError(Session session, Throwable error) {
        logger.debug("---------------------与{}的连接发生错误---------------------",session.getId());
        subOnlineCount();
        CopyOnWriteArraySet<User> users = getUsers(session);
        if (users!=null){
            String nick = "某人";
            for (User user : users) {
                if (user.getId().equals(session.getId())){
                    nick = user.getNickname();
                }
            }
            Map<String,String> result = new HashMap<>();
            result.put("type","init");
            result.put("msg",nick+"离开房间");
            result.put("sendUser","系统消息");
            sendMessagesOther(users,gson.toJson(result));
            User closeUser = getUser(session);
            users.remove(closeUser);
            if (users.size() == 0){
                String room = RoomForUser.get(session.getId());
                UserForRoom.remove(room);
                PwdForRoom.remove(room);
            }
            RoomForUser.remove(session.getId());
        }
        error.printStackTrace();
    }


    public void sendMessage(String message) throws IOException {
        this.session.getBasicRemote().sendText(message);
    }


    /**
     * 获得在线人数
     * @return
     */
    public static synchronized int getOnlineCount() {
        return onlineCount;
    }

    public static synchronized void addOnlineCount() {
        MyWebSocket.onlineCount++;
    }

    public static synchronized void subOnlineCount() {
        MyWebSocket.onlineCount--;
    }


    /**
     * 根据当前用户的session获得他所在房间的所有用户
     * @param session
     * @return
     */
    private CopyOnWriteArraySet<User> getUsers(Session session){
        String room = RoomForUser.get(session.getId());
        CopyOnWriteArraySet<User> users = UserForRoom.get(room);
        return users;
    }

    private User getUser(Session session){
        String room = RoomForUser.get(session.getId());
        CopyOnWriteArraySet<User> users = UserForRoom.get(room);
        for (User user : users){
            if (session.getId().equals(user.getId())){
                return user;
            }
        }
        return null;
    }

    /**
     * 给某个房间的所有人发送消息
     * @param users
     * @param message
     */
    private void sendMessagesAll(CopyOnWriteArraySet<User> users, String message){
        //群发消息
        for (User item : users) {
            try {
                item.getWebSocket().sendMessage(message);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 给某个房间除自己外发送消息
     * @param users
     * @param message
     */
    private void sendMessagesOther(CopyOnWriteArraySet<User> users, String message){
        //群发消息
        for (User item : users) {
            if (item.getWebSocket() != this){
                try {
                    item.getWebSocket().sendMessage(message);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 给某个房间除自己外发送消息
     * @param users
     * @param message
     */
    private void sendMessagesOther(CopyOnWriteArraySet<User> users, String message, String shiel){
        List<String> shiels = Arrays.asList(shiel.split(","));
        //群发消息
        for (User item : users) {
            if (item.getWebSocket() != this && !shiels.contains(item.getId())){
                try {
                    item.getWebSocket().sendMessage(message);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}