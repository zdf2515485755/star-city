package com.zdf.trafficsystem.user.service;

import com.zdf.internalcommon.constant.StatusCode;
import com.zdf.internalcommon.request.AddRoleRequestDto;
import com.zdf.internalcommon.result.ResponseResult;
import com.zdf.trafficsystem.user.entity.RoleEntity;
import com.zdf.trafficsystem.user.repo.RoleRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;

import javax.annotation.Resource;
import java.util.List;

/**
 *@Author mrzhang
 *@Date 2024/3/20 17:06
 */
@Service
public class RoleService {
    @Resource
    private RoleRepository roleRepository;
    private final Logger logger = LoggerFactory.getLogger(RoleService.class);
    public ResponseResult<Boolean> addRole(@Validated @RequestBody AddRoleRequestDto addRoleRequestDto){
        logger.info("Start performing the operation of adding role");
        RoleEntity roleEntity = new RoleEntity();
        BeanUtils.copyProperties(addRoleRequestDto, roleEntity);
        try{
            roleRepository.save(roleEntity);
            logger.info("add role succes");
        }catch (Exception e){
            logger.error("add role error");
            return ResponseResult.fail(StatusCode.SYSTEM_ROLE_ADD_ERROR.getCode(), StatusCode.SYSTEM_ROLE_ADD_ERROR.getMessage(), Boolean.FALSE);
        }
        return ResponseResult.success(Boolean.TRUE);
    }

    public ResponseResult<List<RoleEntity>> queryAllRole(){
        logger.info("Start performing the operation of querying role");
        return ResponseResult.success(roleRepository.findAll());
    }
}
