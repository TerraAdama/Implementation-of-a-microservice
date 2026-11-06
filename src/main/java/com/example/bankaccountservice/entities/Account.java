package com.example.bankaccountservice.entities;

import com.example.bankaccountservice.enums.AccountType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.*;

import java.util.Date;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Account {
    @Id
    private String id;
    private Date createdAt;
    private double balance;
    private String currency;
    private AccountType accountType;
    @ManyToOne
    private Customer customer;
}
