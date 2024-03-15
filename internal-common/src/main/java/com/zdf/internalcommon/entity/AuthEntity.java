package com.zdf.internalcommon.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * @author mrzhang
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
