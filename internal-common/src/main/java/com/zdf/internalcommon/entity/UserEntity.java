package com.zdf.internalcommon.entity;

import lombok.Data;

@Data
public class UserEntity {
  private long uid;
  private String uname;
  private String uaccount;
  private String upass;
  private String umail;
  private String uphone;
  private String t1;
  private String udesc;
  private java.sql.Timestamp utime;
  private long ustatus;
}
