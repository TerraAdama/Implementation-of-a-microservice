package com.example.bankaccountservice.api;

import com.example.bankaccountservice.dto.AccountRequestDTO;
import com.example.bankaccountservice.dto.AccountResponseDTO;
import com.example.bankaccountservice.entities.Account;
import com.example.bankaccountservice.entities.Customer;
import com.example.bankaccountservice.repositories.AccountRepository;
import com.example.bankaccountservice.repositories.CustomerRepository;
import com.example.bankaccountservice.service.AccountServiceImpl;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@AllArgsConstructor
public class AccountGraphQlApi {

    private final AccountRepository accountRepository;
    private final AccountServiceImpl accountService;
    private final CustomerRepository customerRepository;


    @QueryMapping
    public List<Account> accountList(){
        return accountRepository.findAll();
    }

    @QueryMapping
    public Account accountById(String id){
        return accountRepository.findById(id).orElse(null);
    }

    @MutationMapping
    public AccountResponseDTO addAccount(@Argument AccountRequestDTO account){
        return accountService.addAccount(account);
    }

    @MutationMapping
    public AccountResponseDTO updateAccount(@Argument String id,@Argument AccountRequestDTO account){
        return accountService.updateAccount(id,account);
    }

    @MutationMapping
    public Boolean deleteAccount(@Argument String id){
        return accountService.deleteAccount(id);
    }

    @QueryMapping
    public List<Customer> customerList(){
        return customerRepository.findAll();
    }
}

@Data
@AllArgsConstructor
@NoArgsConstructor
class AccountDTO{
    String type;
    String currency;
    String balance;
}