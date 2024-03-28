package com.zdf.internalcommon.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 *@Description 类功能简要描述
 *@Author mrzhang
 *@Date 2024/3/27 01:38
 */
@Data
public class AddWmsShelvesRequestDto implements RequestDto {
    @NotBlank(message = "The length cannot be empty")
    private String length;
    @NotBlank(message = "The height cannot be empty")
    private String height;
    @NotBlank(message = "The width cannot be empty")
    private String width;
    @NotNull(message = "The material cannot be empty")
    private Integer material;
    @NotNull(message = "The status cannot be empty")
    private Integer status;
}
