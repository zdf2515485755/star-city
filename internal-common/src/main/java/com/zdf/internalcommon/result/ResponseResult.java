package com.zdf.internalcommon.result;

import java.io.Serializable;

public class ResponseResult <T> implements Serializable {
    private Integer code;
    private String message;
    private transient T data;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    @Override
    public String toString() {
        return "ResponseResult{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public ResponseResult(Integer code, String message, T data){
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public ResponseResult(Integer code, String message){
        this.code = code;
        this.message = message;
    }


}
