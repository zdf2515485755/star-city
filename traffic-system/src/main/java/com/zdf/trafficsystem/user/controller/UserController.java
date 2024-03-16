package com.zdf.trafficsystem.user.controller;

import com.zdf.internalcommon.request.AddUserRequestDto;
import com.zdf.internalcommon.request.BatchDeleteUserRequestDto;
import com.zdf.internalcommon.result.ResponseResult;
import com.zdf.trafficsystem.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

/**
 * @return null
 * @author mrzhang
 * @description TODO
 * @date 2024/3/16 19:43
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {

    final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * @param addUserRequestDto:
     * @return ResponseResult<Boolean>
     * @author mrzhang
     * @description add user,true:add success,false:add fail
     * @date 2024/3/15 21:54
     */
    @PostMapping("/addUser")
    public ResponseResult<Boolean> addUser(@Validated @RequestBody AddUserRequestDto addUserRequestDto){
        return userService.addUser(addUserRequestDto);
    }

    @GetMapping("/deleteUserByUid/{uid}")
    public ResponseResult<Boolean>deleteUserById(@PathVariable("uid") @NotNull(message = "User ID cannot be null") @Positive(message = "User ID must be a positive number")Integer uid){
        return userService.deleteUserById(uid);
    }

    @PostMapping("/batchDeleteUserByUid")
    public ResponseResult<Boolean>batchDeleteUserByUid(@RequestBody BatchDeleteUserRequestDto batchDeleteUserRequestDto){
        return userService.batchDeleteUserByUid(batchDeleteUserRequestDto);
    }
}
