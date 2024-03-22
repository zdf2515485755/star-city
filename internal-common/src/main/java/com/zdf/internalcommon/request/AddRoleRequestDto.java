package com.zdf.internalcommon.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 *@Description Add role request
 *@Author mrzhang
 *@Date 2024/3/20 16:48
 */
@Data
public class AddRoleRequestDto {
    @NotBlank(message = "The rname cannot be empty")
    private String rname;
    @NotNull(message = "rtye cannot be empty")
    private Integer rtype;
    private String rdesc;
}
