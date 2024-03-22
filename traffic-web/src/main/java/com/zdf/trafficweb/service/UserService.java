package com.zdf.trafficweb.service;

import com.zdf.internalcommon.constant.StatusCode;
import com.zdf.internalcommon.request.LogInRequestDto;
import com.zdf.internalcommon.result.ResponseResult;
import com.zdf.trafficweb.entity.UserInfoEntity;
import com.zdf.trafficweb.repo.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Objects;

/**
 *@Author mrzhang
 *@Date 2024/3/22 23:36
 */
@Service
public class UserService {
    @Resource
    private UserRepository userRepository;
    private final Logger logger = LoggerFactory.getLogger(UserService.class);

    public ResponseResult<Boolean> logIn(LogInRequestDto logInRequestDto){
        logger.info("start login");
        UserInfoEntity userInfoEntity = userRepository.findUserInfoEntityByUserNameEqualsAndUserPassEquals(logInRequestDto.getUserName(), logInRequestDto.getUserPass());
        if (Objects.isNull(userInfoEntity)){
            logger.error("user is not exit");
            return ResponseResult.fail(StatusCode.USER_IS_NOT_EXIT.getCode(), StatusCode.USER_IS_NOT_EXIT.getMessage(), Boolean.FALSE);
        }
        return ResponseResult.success(Boolean.TRUE);

    }
}
