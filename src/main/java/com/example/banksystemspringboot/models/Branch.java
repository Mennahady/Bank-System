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

public class Branch {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long branchId
            ;
    @Column(nullable = false, unique = true)
    private String branchCode;

    @Column(nullable = false)
    private String branchName;

    private String branchAddress;


    @OneToMany(mappedBy = "branch", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<User> users  = new ArrayList<>();


}
