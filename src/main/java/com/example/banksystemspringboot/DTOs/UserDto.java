package com.example.banksystemspringboot.DTOs;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class UserDto {
    private String userName;
    private String address;
    @Pattern(
            regexp = "^[0-9]{3}-[0-9]{3}-[0-9]{4}$",
            message = "Phone number must follow this format: XXX-XXX-XXXX"
    )
    private String phoneNumber;

    @NotBlank(message = "Email is required")
    @Email(message = "Please provide a valid email address")
    private String email;



}
