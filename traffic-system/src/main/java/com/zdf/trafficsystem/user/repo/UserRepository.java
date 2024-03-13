package com.zdf.trafficsystem.user.repo;

import com.zdf.internalcommon.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {
}
