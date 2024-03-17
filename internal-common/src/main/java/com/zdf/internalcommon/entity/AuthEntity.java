package com.zdf.internalcommon.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * @author mrzhang
 * @date 2024/3/16 19:43
 */
@Data
@Entity
@Table(name = "t_auth")
public class AuthEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long aid;
  private String aname;
  private String apath;
  private long atype;
  private long pid;
}
