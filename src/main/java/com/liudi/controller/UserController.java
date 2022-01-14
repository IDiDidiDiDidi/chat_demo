package com.liudi.controller;

import com.liudi.base.WebController;
import com.liudi.dto.UserDto;
import com.liudi.entity.User;
import com.liudi.service.UserService;
import com.liudi.utils.zhenghe.Message;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("user")
@Api(tags = "user", description = "user")
public class UserController extends WebController {

    @Autowired
    private UserService userService;

    @GetMapping("lives")
    public Message getSysAreaLink(UserDto sysAreaDto) {
        return Message.success(userService.getLiveUser());
    }



}
