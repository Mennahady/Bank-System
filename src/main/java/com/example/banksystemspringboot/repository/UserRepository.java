package com.example.banksystemspringboot.repository;

import com.example.banksystemspringboot.models.Branch;
import com.example.banksystemspringboot.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findByEmail(String email);
    boolean existsByEmail(String email);

    List<Branch> findByBranch(Branch branch);

    User findByUserId(Long userId);
}
