package com.zdf.internalcommon.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * @author mrzhang
 * @date 2024/3/16 19:43
 */
@Data
@Entity
@Table(name = "t_role")
public class RoleEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long rid;
  private String rname;
  private long rtype;
  private String rdesc;
}
