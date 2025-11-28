package com.example.banksystemspringboot.DTOs;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class BranchDto {
    @NotBlank(message = "Branch name is required")
    private String branchName;
    @NotBlank(message = "Branch Code is Required")
    @Pattern(regexp = "^[A-Z]{3}[0-9]{3}$", message = "Branch Code must follow Pattern 3letters + 3 numbers")
    private String branchCode;
    private String branchAddress;
}
