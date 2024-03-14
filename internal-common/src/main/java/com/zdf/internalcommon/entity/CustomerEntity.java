package com.zdf.internalcommon.entity;

import lombok.Data;

@Data
public class CustomerEntity {
  private long cid;
  private String cname;
  private String phone;
  private String email;
  private String idcard;
  private long ctype;
  private long csex;
  private String remark;
}
