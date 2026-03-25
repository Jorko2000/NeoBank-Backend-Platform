package com.neobank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.neobank.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
