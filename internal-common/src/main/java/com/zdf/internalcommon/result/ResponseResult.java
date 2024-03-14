package com.zdf.internalcommon.result;

import com.zdf.internalcommon.constant.StatusCode;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@Accessors(chain = true)
public class ResponseResult <T> implements Serializable {
    private Integer code;
    private String message;
    private transient T data;

    public static<T> ResponseResult success(T data)
    {
        return new ResponseResult().setCode(StatusCode.SUCCESS.getCode()).setMessage(StatusCode.SUCCESS.getMessage()).setData(data);
    }
    public static<T> ResponseResult success(Integer code, String message, T data)
    {
        return new ResponseResult().setCode(code).setMessage(message).setData(data);
    }
    public static  ResponseResult fail()
    {
        return new ResponseResult().setCode(StatusCode.FAIL.getCode()).setMessage(StatusCode.FAIL.getMessage());
    }

    public static ResponseResult fail(Integer code, String message)
    {
        return new ResponseResult().setCode(code).setMessage(message);
    }
}
