package com.zdf.internalcommon.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * @author mrzhang
 * @date 2024/3/16 19:43
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
