package com.zdf.trafficsystem.user.service;

import com.zdf.internalcommon.constant.StatusCode;
import com.zdf.internalcommon.constant.UserInfoConstant;
import com.zdf.internalcommon.request.AddUserRequestDto;
import com.zdf.internalcommon.request.BatchDeleteUserRequestDto;
import com.zdf.internalcommon.result.ResponseResult;
import com.zdf.trafficsystem.user.entity.UserEntity;
import com.zdf.trafficsystem.user.repo.UserRepository;
import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;


/**
 * @return null
 * @author mrzhang
 * @description TODO
 * @date 2024/3/16 19:43
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    private final Logger logger = LoggerFactory.getLogger(UserService.class);
    public ResponseResult<Boolean> addUser(AddUserRequestDto addUserRequestDto){
        logger.info("Start performing the operation of adding users");
        UserEntity userEntity = new UserEntity();
        userEntity.setUtime(LocalDateTime.now());
        BeanUtils.copyProperties(addUserRequestDto, userEntity);
        userEntity.setUpass(DigestUtils.md5Hex(addUserRequestDto.getUpass()));
        try {
            userRepository.save(userEntity);
            logger.info("end performing the operation of adding users");
        }catch (Exception e){
            logger.error("add user error");
            return ResponseResult.fail(Boolean.FALSE);
        }
        return ResponseResult.success(Boolean.TRUE);
    }

    public ResponseResult<Boolean>deleteUserById(Integer uid){
        Optional<UserEntity> userEntityOptional = userRepository.findById(uid.longValue());
        if (userEntityOptional.isPresent()){
            UserEntity userEntity = userEntityOptional.get();
            logger.info("get the userEntity: {}" , userEntity);
            userEntity.setUstatus(UserInfoConstant.USER_STATUS_DELETE);
            try{
                userRepository.save(userEntity);
                logger.info("delete user status succes");
            }catch (Exception e){
                logger.error("delete user status fail");
                return ResponseResult.fail(Boolean.FALSE);
            }
            return ResponseResult.success(Boolean.TRUE);
        }
        logger.error("user is not exit");
        return ResponseResult.fail(StatusCode.SYSTEM_USER_IS_NOT_EXIT.getCode(), StatusCode.SYSTEM_USER_IS_NOT_EXIT.getMessage(), Boolean.FALSE);
    }

    public ResponseResult<Boolean>batchDeleteUserByUid(BatchDeleteUserRequestDto batchDeleteUserRequestDto){
        List<Long> uidList = batchDeleteUserRequestDto.getUidList();
        if (Objects.isNull(uidList) || uidList.isEmpty()){
            logger.error("uidList is empty");
            return ResponseResult.fail(Boolean.FALSE);
        }
        List<UserEntity> userEntityList = userRepository.findAllById(uidList);
        if (userEntityList.size() != uidList.size()){
            logger.error("user is not exit");
            return ResponseResult.fail(StatusCode.SYSTEM_USER_IS_NOT_EXIT.getCode(), StatusCode.SYSTEM_USER_IS_NOT_EXIT.getMessage(), Boolean.FALSE);
        }
        userEntityList.forEach(userEntity -> userEntity.setUstatus(UserInfoConstant.USER_STATUS_DELETE));
        try{
            userRepository.saveAll(userEntityList);
            logger.info("delete user status succes");
        }catch (Exception e){
            logger.error("delete user status fail");
            return ResponseResult.fail(Boolean.FALSE);
        }
        return ResponseResult.success(Boolean.TRUE);
    }
}
