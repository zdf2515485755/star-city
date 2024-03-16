package com.zdf.internalcommon.constant;

import lombok.Getter;

/**
 * @return null
 * @author mrzhang
 * @description TODO
 * @date 2024/3/16 19:43
 */
@Getter
public enum StatusCode {
    //成功
    SUCCESS(1, "SUCCESS"),
    FAIL(0, "FAIL"),
    SYSTEM_USER_ADD_ERROR(10000, "SYSTEM USER ADD ERROR"),
    SYSTEM_USER_IS_NOT_EXIT(10004, "USER IS NOT EXIT"),
    SYSTEM_ROLE_ADD_ERROR(10001, "SYSTEM ROLE ADD ERROR"),
    CUSTOMER_ADD_ERROR(10002, "CUSTOMER ADD ERROR");

    private final int code;
    private final String message;

    StatusCode(int code, String message){
        this.code = code;
        this.message = message;
    }
}
