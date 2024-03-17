package com.zdf.internalcommon.request;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.time.LocalDateTime;

/**
 *@Description update user request class
 *@Author mrzhang
 *@Date 2024/3/16 21:01
 */
@Data
public class UpdateUserRequestDto {
    @NotNull(message = "UID cannot be empty")
    private Long uid;
    private String uname;
    private String uaccount;
    private String upass;
    @Email
    private String umail;
    @Pattern(regexp = "^1[3,4,5,6,7,8,9]\\d{9}$", message = "The phone number format should be correct")
    private String uphone;
    private String t1;
    private String udesc;
    private LocalDateTime utime;
    private Integer ustatus;
}
