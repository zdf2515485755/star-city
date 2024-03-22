package com.zdf.trafficweb.entity;

import lombok.Data;

import javax.persistence.*;

/**
 *@Author mrzhang
 *@Date 2024/3/22 23:39
 */

@Entity
@Data
@Table(name = "user_info")
public class UserInfoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long uid;
    @Column(name = "user_name")
    private String userName;
    @Column(name = "user_pass")
    private String userPass;

}
