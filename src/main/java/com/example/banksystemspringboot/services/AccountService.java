package com.example.banksystemspringboot.services;

import com.example.banksystemspringboot.DTOs.AccountDto;
import com.example.banksystemspringboot.models.Account;
import com.example.banksystemspringboot.repository.AccountRepository;
import com.example.banksystemspringboot.repository.BranchRepository;
import com.example.banksystemspringboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
    @Autowired
    AccountRepository accountRepository;
    @Autowired
    UserRepository  userRepository;

    public Account createAccount(AccountDto accountDto) {
        if ()
    }

}
