package com.zdf.internalcommon.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 *@Description Login request
 *@Author mrzhang
 *@Date 2024/3/22 23:55
 */
@Data
public class LogInRequestDto {
    @NotBlank(message = "username can not be empty")
    private String userName;
    @NotBlank(message = "userpass can not be empty")
    private String userPass;
}
