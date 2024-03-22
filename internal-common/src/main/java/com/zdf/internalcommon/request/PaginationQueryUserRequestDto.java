package com.zdf.internalcommon.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.zdf.internalcommon.constraints.DateTimeRangeCheck;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.time.LocalDateTime;

/**
 *@Description Pagination Query User Request
 *@Author mrzhang
 *@Date 2024/3/18 19:34
 */
@Data
public class PaginationQueryUserRequestDto {
    private String uname;
    private String uaccount;
    private String upass;
    @Email
    private String umail;
    @Pattern(regexp = "^1[3,4,5,6,7,8,9]\\d{9}$", message = "The phone number format should be correct")
    private String uphone;
    private String udesc;
    private Integer ustatus;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeRangeCheck
    private LocalDateTime utime;
    @NotNull(message = "currentPage cannot be empty")
    private Integer currentPage;
    @NotNull(message = "pageSize cannot be empty")
    private Integer pageSize;
}
