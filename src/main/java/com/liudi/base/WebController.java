package com.liudi.base;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.liudi.utils.zhenghe.BeanCopyUtil;
import com.liudi.utils.zhenghe.Message;

import java.net.URLDecoder;
import java.util.Iterator;
import java.util.List;

public class WebController<T> extends BaseController {
    public WebController() {
    }

    public Message Success() {
        return Message.success();
    }

    public Message Success(Object obj) {
        return Message.success(obj);
    }

    public Message Fail() {
        return Message.fail();
    }

    public Message Fail(Object obj) {
        return Message.fail(obj);
    }

    public Message Error() {
        return Message.exception();
    }

    public Message Error(Object obj) {
        return Message.exception(obj);
    }

    protected Page<T> startPage(Integer pageNum, Integer pageSize) {
        Page<T> page = null;
        if (StringUtil.isNotNull(pageNum) && StringUtil.isNotNull(pageSize)) {
            page = new Page((long)pageNum, (long)pageSize);
        }

        return page;
    }

    protected Page<T> startPage() {
        Page<T> page = null;
        Integer pageNum = ServletUtil.getParameterToInt("pageNum");
        Integer pageSize = ServletUtil.getParameterToInt("pageSize");
        String orderByColumn = ServletUtil.getParameter("orderByColumn");
        String isAsc = ServletUtil.getParameter("isAsc");
        if (StringUtil.isNotNull(pageNum) && StringUtil.isNotNull(pageSize)) {
            page = new Page((long)pageNum, (long)pageSize);
            if (StringUtil.isNotEmpty(orderByColumn)) {
                String orderColumn = StringUtil.toUnderScoreCase(orderByColumn);
                OrderItem orderItem = new OrderItem();
                orderItem.setColumn(orderColumn);
                if ("desc".equals(isAsc)) {
                    orderItem.setAsc(false);
                    page.addOrder(new OrderItem[]{orderItem});
                } else {
                    orderItem.setAsc(true);
                    page.addOrder(new OrderItem[]{orderItem});
                }
            }
        }

        return page;
    }

    protected Page<T> startPage(PageDto pageDto) {
        Page<T> page = null;
        Integer pageNum = pageDto.getPageNum();
        if (pageNum == null) {
            pageNum = ServletUtil.getParameterToInt("pageNum");
        }

        Integer pageSize = pageDto.getPageSize();
        if (pageSize == null) {
            pageSize = ServletUtil.getParameterToInt("pageSize");
        }

        String orderByColumn = pageDto.getOrderByColumn();
        if (StringUtil.isEmpty(orderByColumn)) {
            orderByColumn = ServletUtil.getParameter("orderByColumn");
        }

        String isAsc = pageDto.getIsAsc();
        if (StringUtil.isEmpty(isAsc)) {
            isAsc = ServletUtil.getParameter("isAsc");
        }

        if (StringUtil.isNotNull(pageNum) && StringUtil.isNotNull(pageSize)) {
            page = new Page((long)pageNum, (long)pageSize);
            if (StringUtil.isNotEmpty(orderByColumn)) {
                String orderColumn = StringUtil.toUnderScoreCase(orderByColumn);
                OrderItem orderItem = new OrderItem();
                orderItem.setColumn(orderColumn);
                if ("desc".equals(isAsc)) {
                    orderItem.setAsc(false);
                    page.addOrder(new OrderItem[]{orderItem});
                } else {
                    orderItem.setAsc(true);
                    page.addOrder(new OrderItem[]{orderItem});
                }
            }
        }

        return page;
    }

    protected PageResult getPageResult(List<?> list, Integer pageNum, Integer pageSize, Integer total) {
        PageResult rspData = new PageResult(list, new PageInfo(pageNum, pageSize), (long)total);
        return rspData;
    }

    protected PageResult getPageResult(List<?> list, Integer pageNum, Integer pageSize, Long total) {
        PageResult rspData = new PageResult(list, new PageInfo(pageNum, pageSize), total);
        return rspData;
    }

    protected PageResult getPageResult(List<?> list, Integer total) {
        return this.getPageResult(list, this.findPageNum(), this.findPageSize(), total);
    }

    protected PageResult getPageResult(List<?> list, Long total) {
        return this.getPageResult(list, this.findPageNum(), this.findPageSize(), total);
    }

    protected PageCustomResult getPageResult(List<?> list, Integer pageNum, Integer pageSize, Integer total, List<?> listCus) {
        PageCustomResult rspData = new PageCustomResult(list, new PageInfo(pageNum, pageSize), (long)total, listCus);
        return rspData;
    }

    protected PageCustomResult getPageResult(List<?> list, Integer total, List<?> listCus) {
        return this.getPageResult(list, this.findPageNum(), this.findPageSize(), total, listCus);
    }

    public String findUserId() {
        return this.getRequest().getHeader("x-userid-header");
    }

    public SysUserHeaderVo findUserInfo() {
        String userInfo = this.getRequest().getHeader("x-user-header-info");
        Object json = JSONObject.parse(userInfo);
        SysUserHeaderVo sysUserHeaderVo = (SysUserHeaderVo) BeanCopyUtil.convertBean(json, SysUserHeaderVo.class);
        return sysUserHeaderVo;
    }

    public String findUserName() {
        String userName = "";
        String header = this.getRequest().getHeader("x-user-header");
        if (StringUtil.isNotEmpty(header)) {
            if (header.contains(":")) {
                String[] split = header.split(":");
                if (split != null && split.length > 1) {
                    userName = split[1];
                }
            } else {
                userName = header;
            }
        }

        return userName;
    }

    public String findDeptId() {
        return this.getRequest().getHeader("x-deptid-header");
    }

    public String findUserIds() {
        String userIds = this.getRequest().getHeader("x-user-header-ids");
        return userIds;
    }

    public Integer findPageNum() {
        return ServletUtil.getParameterToInt("pageNum");
    }

    public Integer findPageSize() {
        return ServletUtil.getParameterToInt("pageSize");
    }

    public List<CustomVo> customShow(List<String> list, Class classz) {
        List<CustomVo> customVos = CustomUtil.voConcert(classz);
        if (customVos.size() == 0) {
            return null;
        } else {
            if (list != null && list.size() > 0) {
                Iterator var4 = customVos.iterator();

                while(var4.hasNext()) {
                    CustomVo customVo = (CustomVo)var4.next();
                    String key = customVo.getKey();
                    customVo.setShow(false);
                    Iterator var7 = list.iterator();

                    while(var7.hasNext()) {
                        String str = (String)var7.next();
                        if (str.equals(key)) {
                            customVo.setShow(true);
                        }
                    }
                }
            }

            return customVos;
        }
    }

    public QueryWrapper wrapperBuilder(QueryWrapper wrapper, T t) {
        if (t instanceof PageDto) {
            PageDto dto = (PageDto)t;
            String aliasSearchStr = dto.getAliasSearchStr();
            if (StringUtil.isNotEmpty(aliasSearchStr)) {
                try {
                    aliasSearchStr = URLDecoder.decode(aliasSearchStr, "UTF-8");
                } catch (Exception var13) {
                }

                JSONArray json = JSONArray.parseArray(aliasSearchStr);
                if (json != null && json.size() > 0) {
                    for(int i = 0; i < json.size(); ++i) {
                        JSONObject jsonObject = json.getJSONObject(i);
                        CustomSearchVo map = (CustomSearchVo)JSON.toJavaObject(jsonObject, CustomSearchVo.class);
                        String key = map.getKey();
                        String rule = map.getRule();
                        String columnName = map.getColumnName();
                        Object contentValue = map.getContentValue();
                        key = StringUtil.humpToLine(key);
                        if (StringUtil.isNotEmpty(columnName)) {
                            key = columnName;
                        }

                        this.getwrapperBuilder(wrapper, key, rule, contentValue);
                    }
                }
            }
        }

        return wrapper;
    }

    public QueryWrapper getwrapperBuilder(QueryWrapper<T> wrapper, String key, String rule, Object contentValue) {
        if (CompareEnum.EQ.getCode().equals(rule)) {
            if (StringUtil.isNullObj(contentValue)) {
                wrapper.eq(key, contentValue);
            }
        } else if (CompareEnum.NE.getCode().equals(rule)) {
            if (StringUtil.isNullObj(contentValue)) {
                wrapper.ne(key, contentValue);
            }
        } else if (CompareEnum.GT.getCode().equals(rule)) {
            if (StringUtil.isNullObj(contentValue)) {
                wrapper.gt(key, contentValue);
            }
        } else if (CompareEnum.GE.getCode().equals(rule)) {
            if (StringUtil.isNullObj(contentValue)) {
                wrapper.ge(key, contentValue);
            }
        } else if (CompareEnum.LT.getCode().equals(rule)) {
            if (StringUtil.isNullObj(contentValue)) {
                wrapper.lt(key, contentValue);
            }
        } else if (CompareEnum.LE.getCode().equals(rule)) {
            if (StringUtil.isNullObj(contentValue)) {
                wrapper.le(key, contentValue);
            }
        } else if (CompareEnum.LIKE.getCode().equals(rule) && StringUtil.isNullObj(contentValue)) {
            wrapper.like(key, contentValue);
        }

        return wrapper;
    }

    public List<CustomSearchVo> customSearchShow(List<String> list, T t) {
        List<CustomSearchVo> customVos = CustomSearchUtil.voConcert(t.getClass());
        if (customVos.size() == 0) {
            return null;
        } else {
            if (list != null && list.size() > 0) {
                Iterator var4 = customVos.iterator();

                while(var4.hasNext()) {
                    CustomSearchVo customVo = (CustomSearchVo)var4.next();
                    String key = customVo.getKey();
                    customVo.setShow(false);
                    Iterator var7 = list.iterator();

                    while(var7.hasNext()) {
                        String str = (String)var7.next();
                        if (str.equals(key)) {
                            customVo.setShow(true);
                        }
                    }
                }
            }

            return customVos;
        }
    }
}
