package com.zdf.internalcommon.entity;

import lombok.Data;

@Data
public class AuthEntity {
  private long aid;
  private String aname;
  private String apath;
  private long atype;
  private long pid;
}
