package com.example.banksystemspringboot.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long transactionId;
    @Column(nullable = false)
    private String transactionType;
    @Column(nullable = false)
    private double amount;
    @Column(nullable = false, updatable = false)
    private LocalDateTime timestamp;
    @PrePersist
    protected  void onCreate() {
        this.timestamp = LocalDateTime.now();
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "source_account_id", nullable = false)
    private Account sourceAccount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "target_account_id", nullable = false)
    private Account targetAccount;
}
