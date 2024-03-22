package com.zdf.trafficsystem.user.repo;

import com.zdf.trafficsystem.user.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *@Author mrzhang
 *@Date 2024/3/20 16:42
 */
@Repository
public interface RoleRepository extends JpaRepository<RoleEntity, Long> {
}
