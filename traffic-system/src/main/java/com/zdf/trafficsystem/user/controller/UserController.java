package com.zdf.trafficsystem.user.controller;

import com.zdf.internalcommon.request.AddUserRequestDto;
import com.zdf.internalcommon.result.ResponseResult;
import com.zdf.trafficsystem.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author mrzhang
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {

    final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/addUser")
    public ResponseResult<Boolean> addUser(@Validated @RequestBody AddUserRequestDto addUserRequestDto){
        return userService.addUser(addUserRequestDto);
    }

}
