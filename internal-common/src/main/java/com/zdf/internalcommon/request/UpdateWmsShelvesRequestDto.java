package com.zdf.internalcommon.request;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 *@Description 类功能简要描述
 *@Author mrzhang
 *@Date 2024/3/27 21:32
 */
@Data
public class UpdateWmsShelvesRequestDto implements RequestDto {
    @NotNull(message = "The sid cannot be empty")
    private Long sid;
    private String length;
    private String height;
    private String width;
    private Integer material;
    private Integer status;
}
