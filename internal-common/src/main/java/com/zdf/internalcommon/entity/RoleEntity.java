package com.zdf.internalcommon.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * @author mrzhang
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
