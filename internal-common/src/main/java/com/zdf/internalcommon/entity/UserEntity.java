package com.zdf.internalcommon.entity;

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


  public long getUid() {
    return uid;
  }

  public void setUid(long uid) {
    this.uid = uid;
  }


  public String getUname() {
    return uname;
  }

  public void setUname(String uname) {
    this.uname = uname;
  }


  public String getUaccount() {
    return uaccount;
  }

  public void setUaccount(String uaccount) {
    this.uaccount = uaccount;
  }


  public String getUpass() {
    return upass;
  }

  public void setUpass(String upass) {
    this.upass = upass;
  }


  public String getUmail() {
    return umail;
  }

  public void setUmail(String umail) {
    this.umail = umail;
  }


  public String getUphone() {
    return uphone;
  }

  public void setUphone(String uphone) {
    this.uphone = uphone;
  }


  public String getT1() {
    return t1;
  }

  public void setT1(String t1) {
    this.t1 = t1;
  }


  public String getUdesc() {
    return udesc;
  }

  public void setUdesc(String udesc) {
    this.udesc = udesc;
  }


  public java.sql.Timestamp getUtime() {
    return utime;
  }

  public void setUtime(java.sql.Timestamp utime) {
    this.utime = utime;
  }


  public long getUstatus() {
    return ustatus;
  }

  public void setUstatus(long ustatus) {
    this.ustatus = ustatus;
  }

}
