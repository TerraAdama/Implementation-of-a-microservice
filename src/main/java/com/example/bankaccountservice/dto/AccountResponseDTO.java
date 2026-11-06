package com.example.bankaccountservice.dto;

import com.example.bankaccountservice.enums.AccountType;

import java.util.Date;

public class AccountResponseDTO {
    private String id;
    private Date createdAt;
    private double balance;
    private String currency;
    private AccountType accountType;
}
