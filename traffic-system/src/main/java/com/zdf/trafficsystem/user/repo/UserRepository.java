package com.zdf.trafficsystem.user.repo;

import com.zdf.trafficsystem.user.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author mrzhang
 */
@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {
}
