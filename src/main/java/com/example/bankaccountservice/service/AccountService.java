package com.example.bankaccountservice.service;

import com.example.bankaccountservice.dto.AccountRequestDTO;
import com.example.bankaccountservice.dto.AccountResponseDTO;

public interface AccountService {

    AccountResponseDTO addAccount(AccountRequestDTO accountRequestDTO);

    AccountResponseDTO updateAccount(String id, AccountRequestDTO accountRequestDTO);

    Boolean deleteAccount(String id);
}
