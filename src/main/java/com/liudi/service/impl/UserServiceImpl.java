package com.liudi.service.impl;

import com.liudi.entity.SysUser;
import com.liudi.mapper.UserMapper;
import com.liudi.service.UserService;
import com.liudi.utils.zhenghe.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public Message getLiveUser() {
        List<SysUser> liveUser = userMapper.getLiveUser();
        List<String> baseId = liveUser.stream()
                .filter(Objects::nonNull)
                .map(SysUser::getBaseId)
                .collect(Collectors.toList());

        redisTemplate.boundSetOps("roomId").add(UUID.randomUUID());
        log.info("======== add redis roomId");

        return Message.success(liveUser);
    }
}
