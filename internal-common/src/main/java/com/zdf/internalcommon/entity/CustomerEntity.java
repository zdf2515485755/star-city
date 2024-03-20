package com.zdf.internalcommon.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * @author mrzhang
 * @date 2024/3/16 19:43
 */
@Data
@Entity
@Table(name = "t_customer")
public class CustomerEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long cid;
  private String cname;
  private String phone;
  private String email;
  private String idcard;
  private Integer ctype;
  private Integer csex;
  private String remark;
}
