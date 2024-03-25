package com.zdf.trafficweb.interceptor;

import com.zdf.internalcommon.result.TokenResult;
import com.zdf.internalcommon.util.JwtUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

/**
 *@Description 类功能简要描述
 *@Author mrzhang
 *@Date 2024/3/25 03:26
 */
public class JwtInterceptor implements HandlerInterceptor {
    private final Logger logger = LoggerFactory.getLogger(JwtInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception{
        String token = request.getHeader("Authorization");
        if (Objects.isNull(token)){
            logger.error("User not logged in");
            return Boolean.FALSE;
        }

        TokenResult tokenResult = JwtUtil.checkToken(token);
        if (Objects.isNull(tokenResult)){
            logger.error("illegal user");
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }
}
