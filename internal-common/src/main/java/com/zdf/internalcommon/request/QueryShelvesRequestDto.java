package com.zdf.internalcommon.request;

import lombok.Data;

/**
 *@Description 类功能简要描述
 *@Author mrzhang
 *@Date 2024/3/27 19:41
 */
@Data
public class QueryShelvesRequestDto implements RequestDto{

    private Long sid;

    private String length;

    private String height;

    private String width;

    private Integer material;

    private Integer status;
}
