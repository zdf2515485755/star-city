package com.zdf.trafficsystem.user.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * @author mrzhang
 */
@Data
@Entity
@Table(name = "t_user")
public class UserEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long uid;
  @Column(name = "uname")
  private String uname;
  @Column(name = "uaccount")
  private String uaccount;
  @Column(name = "upass")
  private String upass;
  @Column(name = "umail")
  private String umail;
  @Column(name = "uphone")
  private String uphone;
  @Column(name = "t1")
  private String t1;
  @Column(name = "udesc")
  private String udesc;
  @Column(name = "utime")
  private LocalDateTime utime;
  @Column(name = "ustatus")
  private long ustatus;
}