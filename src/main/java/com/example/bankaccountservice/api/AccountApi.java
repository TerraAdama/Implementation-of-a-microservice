package com.example.bankaccountservice.api;

import com.example.bankaccountservice.dto.AccountRequestDTO;
import com.example.bankaccountservice.dto.AccountResponseDTO;
import com.example.bankaccountservice.entities.Account;
import com.example.bankaccountservice.repositories.AccountRepository;
import com.example.bankaccountservice.service.AccountService;
import com.example.bankaccountservice.service.AccountServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(name = "account")
public class AccountApi {

    private final AccountRepository accountRepository;

    private final AccountService accountService;

    @PostMapping("/save")
    public AccountResponseDTO save(@RequestBody AccountRequestDTO accountRequestDTO) {
        return accountService.addAccount(accountRequestDTO);
    }

    @GetMapping
    public List<Account> getAccounts(){
        return accountRepository.findAll();
    }
}
