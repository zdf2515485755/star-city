package com.zdf.internalcommon.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * @return null
 * @author mrzhang
 * @description TODO
 * @date 2024/3/16 19:43
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
