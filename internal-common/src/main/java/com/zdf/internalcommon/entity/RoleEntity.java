package com.zdf.internalcommon.entity;

import lombok.Data;

@Data
public class RoleEntity {
  private long rid;
  private String rname;
  private long rtype;
  private String rdesc;
}
