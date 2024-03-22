package com.zdf.trafficweb.repo;

import com.zdf.trafficweb.entity.UserInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *@Author mrzhang
 *@Date 2024/3/22 23:38
 */
public interface UserRepository extends JpaRepository<UserInfoEntity, Long> {

    /**
     * @param userName:
     * @param userPass:
     * @return UserInfoEntity
     * @author mrzhang
     * @description Query user information based on username and userpass
     * @date 2024/3/23 02:25
     */
    UserInfoEntity findUserInfoEntityByUserNameEqualsAndUserPassEquals(String userName, String userPass);
}
