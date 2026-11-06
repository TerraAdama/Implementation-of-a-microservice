package com.example.bankaccountservice.service;

import com.example.bankaccountservice.dto.AccountRequestDTO;
import com.example.bankaccountservice.dto.AccountResponseDTO;
import com.example.bankaccountservice.entities.Account;
import com.example.bankaccountservice.mapper.AccountMapper;
import com.example.bankaccountservice.repositories.AccountRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.UUID;

@Service
@Transactional
@AllArgsConstructor
public class AccountServiceImpl implements AccountService{

    private final AccountRepository accountRepository;

    private final AccountMapper mapper;

    @Override
    public AccountResponseDTO addAccount(AccountRequestDTO accountRequestDTO) {
        Account account = Account.builder().id(UUID.randomUUID().toString()).accountType(accountRequestDTO.getAccountType()).balance(accountRequestDTO.getBalance()).currency(accountRequestDTO.getCurrency()).createdAt(new Date()).build();
        Account saveAccount = accountRepository.save(account);
        return mapper.toDto(saveAccount);
    }

    public AccountResponseDTO updateAccount(String id, AccountRequestDTO accountRequestDTO) {
        Account account = Account.builder().id(id).accountType(accountRequestDTO.getAccountType()).balance(accountRequestDTO.getBalance()).currency(accountRequestDTO.getCurrency()).createdAt(new Date()).build();
        Account saveAccount = accountRepository.save(account);
        return mapper.toDto(saveAccount);
    }

    public Boolean deleteAccount(String id) {
        accountRepository.deleteById(id);
        return true;
    }
}
