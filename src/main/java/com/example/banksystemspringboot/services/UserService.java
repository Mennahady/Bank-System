package com.example.banksystemspringboot.services;

import com.example.banksystemspringboot.DTOs.UserDto;
import com.example.banksystemspringboot.models.Account;
import com.example.banksystemspringboot.models.Branch;
import com.example.banksystemspringboot.models.User;
import com.example.banksystemspringboot.repository.AccountRepository;
import com.example.banksystemspringboot.repository.BranchRepository;
import com.example.banksystemspringboot.repository.UserRepository;
import jdk.jshell.spi.ExecutionControl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BranchRepository branchRepository;
    @Autowired
    private AccountRepository accountRepository;

    public User createUser(UserDto userDto) {

        if (userRepository.existsByEmail(userDto.getEmail())) {
            throw new IllegalArgumentException("Email already exists");
        }

        User user = new User();
        user.setName(userDto.getUserName());
        user.setAddress(userDto.getAddress());
        user.setPhoneNumber(userDto.getPhoneNumber());
        user.setEmail(userDto.getEmail());

        Branch branch = findNearestBranch(userDto.getAddress());
        user.setBranch(branch);

        return userRepository.save(user);
    }

    private Branch findNearestBranch(String address) {
        Optional<Branch> branch = branchRepository.findByBranchAddressContainingIgnoreCase(address);
        return branch.orElse(null) ;

    }

    public User getUserDetails(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found with ID: " + userId));
    }




    public User  linkUserToBranch(Long userId, Long branchId){
        User user = getUserDetails(userId);
        Branch branch = branchRepository.findById(branchId)
                .orElseThrow(() -> new RuntimeException("Branch not found with ID: " + branchId));
        user.setBranch(branch);
        return userRepository.save(user);
    }

    public List<Account> getUserAccounts(Long userId) {
        User user = getUserDetails(userId);
        return accountRepository.findByUser(user);
    }


}




