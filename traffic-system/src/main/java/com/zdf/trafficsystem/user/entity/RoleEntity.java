package com.zdf.trafficsystem.user.entity;

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
  private Long rid;
  @Column(name = "rname")
  private String rname;
  @Column(name = "rtype")
  private Integer rtype;
  @Column(name = "rdesc")
  private String rdesc;
}
