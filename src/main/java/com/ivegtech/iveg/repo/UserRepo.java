package com.ivegtech.iveg.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ivegtech.iveg.entity.User;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);

    Optional<User> findByPhone(String phone);
    
    List<User> findByRoleId(Long roleId);
}
