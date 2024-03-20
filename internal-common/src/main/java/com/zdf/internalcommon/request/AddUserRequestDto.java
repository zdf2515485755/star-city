package com.zdf.internalcommon.request;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

/**
 * @author mrzhang
 * @description add user request class
 * @date 2024/3/16 19:43
 */
@Data
public class AddUserRequestDto{

    @NotBlank(message = "The username cannot be empty")
    private String uname;
    @NotBlank(message = "The account cannot be empty")
    private String uaccount;
    @NotBlank(message = "The password cannot be empty")
    private String upass;
    @Email
    private String umail;
    @NotBlank(message = "The phone number cannot be empty")
    @Pattern(regexp = "^1[3,4,5,6,7,8,9]\\d{9}$", message = "The phone number format should be correct")
    private String uphone;
    private String udesc;
    private Integer ustatus;
    @NotBlank(message = "The rid cannot be empty")
    private String rid;
}
