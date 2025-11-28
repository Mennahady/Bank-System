package com.example.banksystemspringboot.DTOs;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class TransactionDto {
    @NotBlank(message = "Transaction type is required")
    private String transactionType;

    @NotNull(message = "Amount is required")
    @Min(value = 0, message = "Amount must be greater than 0")
    private Double amount;


    private Long sourceAccountId;

    private Long targetAccountId;
}
