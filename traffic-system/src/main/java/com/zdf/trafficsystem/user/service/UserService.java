package com.zdf.trafficsystem.user.service;

import com.zdf.internalcommon.request.AddUserRequestDto;
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
import java.util.Objects;


/**
 * @author mrzhang
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
        UserEntity result;
        try {
            result = userRepository.save(userEntity);
            logger.info("end performing the operation of adding users");
        }catch (Exception e){
            logger.error("add user error");
            return ResponseResult.fail(Boolean.FALSE);
        }
        if (Objects.isNull(result)){
            return ResponseResult.fail(Boolean.FALSE);
        }
        return ResponseResult.success(Boolean.TRUE);
    }
}
