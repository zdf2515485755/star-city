package com.zdf.internalcommon.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * @author mrzhang
 */
@Data
@Entity
@Table(name = "t_transport")
public class TransportEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long tid;
}
