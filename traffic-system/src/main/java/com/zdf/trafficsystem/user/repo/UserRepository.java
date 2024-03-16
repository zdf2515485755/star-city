package com.zdf.trafficsystem.user.repo;

import com.zdf.trafficsystem.user.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @return null
 * @author mrzhang
 * @description TODO
 * @date 2024/3/16 19:43
 */
@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
