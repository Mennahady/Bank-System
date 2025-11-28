package com.example.banksystemspringboot.repository;

import com.example.banksystemspringboot.models.Branch;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BranchRepository extends JpaRepository<Branch,Long> {
    //public Branch findByBranchCode(String branchCode);
    Optional<Branch> findByBranchCode(String branchCode);

    boolean existsByBranchCode(String branchCode);

    Branch findByBranchId(Long branchId);

    Optional<Branch> findByBranchAddressContainingIgnoreCase(String branchAddress);
}
