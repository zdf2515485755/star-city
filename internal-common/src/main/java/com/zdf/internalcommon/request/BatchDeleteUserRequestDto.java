package com.zdf.internalcommon.request;

import lombok.Data;

import java.util.List;

/**
 * @Description batch delete user request class
 * @Author mrzhang
 * @Date 2024/3/16 18:48
 */
@Data
public class BatchDeleteUserRequestDto {
    private List<Long> uidList;
}
