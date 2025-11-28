package com.example.banksystemspringboot.services;

import com.example.banksystemspringboot.DTOs.BranchDto;
import com.example.banksystemspringboot.models.Branch;
import com.example.banksystemspringboot.models.User;
import com.example.banksystemspringboot.repository.BranchRepository;
import com.example.banksystemspringboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BranchService {

    @Autowired
    private BranchRepository branchRepository;

    @Autowired
    private UserRepository userRepository;

    // Create a branch
    public Branch createBranch(BranchDto branchDto) {
        if (branchRepository.existsByBranchCode(branchDto.getBranchCode())) {
            throw new IllegalArgumentException(
                    "Branch code already exists: " + branchDto.getBranchCode()
            );
        }

        Branch branch = new Branch();
        branch.setBranchCode(branchDto.getBranchCode());
        branch.setBranchName(branchDto.getBranchName());

        return branchRepository.save(branch);
    }

    // Get branch details by ID
    public Branch getBranchDetails(Long branchId) {
        return branchRepository.findById(branchId)
                .orElseThrow(() -> new RuntimeException(
                        "Branch not found with ID: " + branchId
                ));
    }

    public List<Branch> getAllUsersInBranch(Long branchId) {
        Branch branch = getBranchDetails(branchId);
        return userRepository.findByBranch(branch);
    }



}

