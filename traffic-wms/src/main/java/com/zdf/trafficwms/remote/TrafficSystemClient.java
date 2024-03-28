package com.zdf.trafficwms.remote;

import com.zdf.internalcommon.result.ResponseResult;
import com.zdf.trafficsystem.user.entity.UserEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 *@Description Remote request traffic-system service
 *@Author mrzhang
 *@Date 2024/3/28 20:45
 */
@FeignClient("traffic-system")
public interface TrafficSystemClient {
    /**
     * @return ResponseResult<List<UserEntity>>
     * @author mrzhang
     * @description Remote request query all user
     * @date 2024/3/28 20:51
     */
    @GetMapping("/user/queryAllUser")
    ResponseResult<List<UserEntity>> queryAllUser();
}
