package com.example.bankaccountservice.mapper;

import com.example.bankaccountservice.dto.AccountRequestDTO;
import com.example.bankaccountservice.dto.AccountResponseDTO;
import com.example.bankaccountservice.entities.Account;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, builder = @Builder(disableBuilder = true))
public interface AccountMapper {

    AccountResponseDTO toDto(Account model);

}
