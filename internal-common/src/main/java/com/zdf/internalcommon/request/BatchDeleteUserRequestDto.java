package com.zdf.internalcommon.request;

import lombok.Data;

import java.util.List;

/**
 * @Description 类功能简要描述
 * @Author mrzhang
 * @Date 2024/3/16 18:48
 */
@Data
public class BatchDeleteUserRequestDto {
    private List<Long> uidList;
}
