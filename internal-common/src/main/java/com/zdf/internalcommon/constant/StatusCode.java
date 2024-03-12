package com.zdf.internalcommon.constant;

public enum StatusCode {
    SYSTEM_USER_ADD_ERROR(10000, "SYSTEM USER ADD ERROR"),
    SYSTEM_ROLE_ADD_ERROR(10001, "SYSTEM ROLE ADD ERROR"),
    CUSTOMER_ADD_ERROR(10002, "CUSTOMER ADD ERROR");

    private final int code;
    private final String message;

    StatusCode(int code, String message){
        this.code = code;
        this.message = message;
    }
}
