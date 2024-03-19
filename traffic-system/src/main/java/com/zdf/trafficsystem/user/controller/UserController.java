package com.zdf.trafficsystem.user.controller;

import com.zdf.internalcommon.request.AddUserRequestDto;
import com.zdf.internalcommon.request.BatchDeleteUserRequestDto;
import com.zdf.internalcommon.request.PaginationQueryUserRequestDto;
import com.zdf.internalcommon.request.UpdateUserRequestDto;
import com.zdf.internalcommon.result.ResponseResult;
import com.zdf.trafficsystem.user.entity.UserEntity;
import com.zdf.trafficsystem.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.List;

/**
 * @author mrzhang
 * @description API for operating user information
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
     * @description add user
     * @date 2024/3/15 21:54
     */
    @PostMapping("/addUser")
    public ResponseResult<Boolean> addUser(@Validated @RequestBody AddUserRequestDto addUserRequestDto){
        return userService.addUser(addUserRequestDto);
    }
    /**
     * @param uid:
     * @return ResponseResult<Boolean>
     * @author mrzhang
     * @description Delete user information through UID
     * @date 2024/3/16 22:19
     */
    @GetMapping("/deleteUserByUid/{uid}")
    public ResponseResult<Boolean>deleteUserByUid(@PathVariable("uid") @NotNull(message = "User ID cannot be null") @Positive(message = "User ID must be a positive number")Integer uid){
        return userService.deleteUserByUid(uid);
    }
    /**
     * @param batchDeleteUserRequestDto:
     * @return ResponseResult<Boolean>
     * @author mrzhang
     * @description Batch deletion of user information through UID
     * @date 2024/3/16 22:19
     */
    @PostMapping("/batchDeleteUserByUid")
    public ResponseResult<Boolean>batchDeleteUserByUid(@RequestBody BatchDeleteUserRequestDto batchDeleteUserRequestDto){
        return userService.batchDeleteUserByUid(batchDeleteUserRequestDto);
    }
    /**
     * @param updateUserRequestDto:
     * @return ResponseResult<Boolean>
     * @author mrzhang
     * @description update User
     * @date 2024/3/16 22:20
     */
    @PostMapping("/updateUser")
    public ResponseResult<Boolean>updateUser(@RequestBody UpdateUserRequestDto updateUserRequestDto){
        return userService.updateUser(updateUserRequestDto);
    }
    /**
     * @return ResponseResult<List<UserEntity>>
     * @author mrzhang
     * @description query all user
     * @date 2024/3/18 01:36
     */
    @GetMapping("/queryAllUser")
    public ResponseResult<List<UserEntity>>queryAllUser(){
        return userService.queryAllUser();
    }

    @PostMapping("/paginationQueryrUser")
    public ResponseResult<Page<UserEntity>>paginationQueryrUser(@Validated @RequestBody PaginationQueryUserRequestDto paginationQueryUserRequestDto){
        return userService.paginationQueryrUser(paginationQueryUserRequestDto);
    }
}
