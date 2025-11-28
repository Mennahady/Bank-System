package com.example.banksystemspringboot.repository;

import com.example.banksystemspringboot.models.Account;
import com.example.banksystemspringboot.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account,Long> {
    List<Account> findByUser(User user);
    List<Account> findByuserid(Long userid);
    Optional<Account> findByAccountnumber(Long accountnumber);


}
