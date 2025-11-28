package com.example.banksystemspringboot.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long accountId;
    @Column(nullable = false, unique = true)
    private String accountNumber;
    @Column(nullable = false)
    private Double balance = 0.0;
    @Column(nullable = false)
    private String accountType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @OneToMany(mappedBy = "sourceAccount")
    private List<Transaction> inTransaction = new ArrayList<>();

    @OneToMany(mappedBy = "targetAccount")
    private List<Transaction> outTransaction = new ArrayList<>();
}
