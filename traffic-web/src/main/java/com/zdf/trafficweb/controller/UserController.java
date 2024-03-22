package com.zdf.trafficweb.controller;

import com.zdf.internalcommon.request.LogInRequestDto;
import com.zdf.internalcommon.result.ResponseResult;
import com.zdf.trafficweb.service.UserService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 *@Description  API for operating user information
 *@Author mrzhang
 *@Date 2024/3/22 23:17
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    /**
     * @param logInRequestDto:
     * @return ResponseResult<Boolean>
     * @author mrzhang
     * @description Login
     * @date 2024/3/23 02:24
     */
    @PostMapping("/logIn")
    public ResponseResult<Boolean> logIn(@Validated @RequestBody LogInRequestDto logInRequestDto){
        return userService.logIn(logInRequestDto);
    }
}
