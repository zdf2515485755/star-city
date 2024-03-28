package com.zdf.trafficwms.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * 
 * @author mrzhang
 * @TableName wms_shelves
 */
@TableName(value ="wms_shelves")
@Data
public class WmsShelvesEntity implements Serializable {
    @TableId(type = IdType.AUTO)
    private Integer sid;

    private String length;

    private String height;

    private String width;

    private Integer material;

    private Integer status;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}