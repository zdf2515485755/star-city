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
@Table(name = "t_car")
public class CarEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long cid;
  private String cnumber;
}
