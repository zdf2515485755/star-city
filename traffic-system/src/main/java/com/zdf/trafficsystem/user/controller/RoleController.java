package com.zdf.trafficsystem.user.controller;

import com.zdf.internalcommon.request.AddRoleRequestDto;
import com.zdf.internalcommon.result.ResponseResult;
import com.zdf.trafficsystem.user.entity.RoleEntity;
import com.zdf.trafficsystem.user.service.RoleService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 *@Description 类功能简要描述
 *@Author mrzhang
 *@Date 2024/3/20 16:43
 */
@RestController
@RequestMapping("/role")
public class RoleController {

    @Resource
    private RoleService roleService;

    /**
     * @param addRoleRequestDto:
     * @return ResponseResult<Boolean>
     * @author mrzhang
     * @description add role
     * @date 2024/3/20 17:10
     */
    @PostMapping("/addRole")
    public ResponseResult<Boolean> addRole(@Validated @RequestBody AddRoleRequestDto addRoleRequestDto){
        return roleService.addRole(addRoleRequestDto);
    }

    /**
     * @return ResponseResult<List<RoleEntity>>
     * @author mrzhang
     * @description Query all role
     * @date 2024/3/20 19:26
     */
    @GetMapping("/queryAllRole")
    public ResponseResult<List<RoleEntity>> queryAllRole(){
        return roleService.queryAllRole();
    }
}
