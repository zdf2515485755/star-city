package com.zdf.internalcommon.constant;

import lombok.Getter;

/**
 * @author mrzhang
 * @description Status code
 * @date 2024/3/16 19:43
 */
@Getter
public enum StatusCode {
    //成功
    SUCCESS(1, "SUCCESS"),
    FAIL(0, "FAIL"),
    SYSTEM_USER_ADD_ERROR(10000, "SYSTEM USER ADD ERROR"),
    SYSTEM_USER_DELETE_ERROR(10001, "SYSTEM USER DELETE ERROR"),
    SYSTEM_USER_UPDATE_ERROR(10002, "SYSTEM USER UPDATE ERROR"),
    SYSTEM_USER_IS_NOT_EXIT(10003, "USER IS NOT EXIT"),
    SYSTEM_ROLE_ADD_ERROR(10004, "SYSTEM ROLE ADD ERROR"),
    CUSTOMER_ADD_ERROR(10005, "CUSTOMER ADD ERROR"),
    SYSTEM_ROLE_ID_IS_NULL(10006, "ROLE ID IS NULL"),
    ROLE_ID_IS_NOT_EXIT(10007, "ROLE ID IS NOT EXIT"),
    ROLE_ID_FORMAT_IS_VALID(10008, "ROLE ID FORMAT IS VALID"),
    USER_IS_NOT_EXIT(10009, "USER IS NOT EXIT");


    private final int code;
    private final String message;

    StatusCode(int code, String message){
        this.code = code;
        this.message = message;
    }
}
