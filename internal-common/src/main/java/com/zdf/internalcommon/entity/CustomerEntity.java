package com.zdf.internalcommon.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * @author mrzhang
 */
@Data
@Entity
@Table(name = "t_customer")
public class CustomerEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long cid;
  private String cname;
  private String phone;
  private String email;
  private String idcard;
  private long ctype;
  private long csex;
  private String remark;
}
