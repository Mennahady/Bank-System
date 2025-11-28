package com.example.banksystemspringboot.repository;

import com.example.banksystemspringboot.models.Account;
import com.example.banksystemspringboot.models.Transaction;
import org.springframework.cglib.core.Local;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    @Query("SELECT t FROM Transaction t WHERE t.sourceAccount.accountId\n" +
            " = :accountId OR t.targetAccount.accountId = :accountId ORDER BY t.timestamp DESC")
    List<Transaction> findByAccountId(@Param("accountId") Long accountId);

    List<Transaction> findBySourceAccount(Account sourceAccount);
    List<Transaction> findByTargetAccount(Account targetAccount);

    @Query("SELECT t FROM Transaction t " +
            "WHERE t.timestamp BETWEEN :startDate AND :endDate " +
            "  AND (:transactionType IS NULL OR t.transactionType = :transactionType) " +
            "ORDER BY t.timestamp DESC")
    List<Transaction> findByDateRangeAndType(
            @Param("startDate") LocalDateTime startDate,
            @Param("endDate") LocalDateTime endDate,
            @Param("transactionType") String transactionType);
}
