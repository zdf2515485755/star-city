package com.zdf.internalcommon.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * @author mrzhang
 */
@Data
@Entity
@Table(name = "t_user_role")
public class UserRoleEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  private long uid;
  private long rid;
}
