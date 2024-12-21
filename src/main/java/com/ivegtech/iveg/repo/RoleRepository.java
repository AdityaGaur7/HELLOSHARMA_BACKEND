package com.ivegtech.iveg.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ivegtech.iveg.entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long>{
  
	Optional<Role> findByRoleName(String roleName);
	
}
