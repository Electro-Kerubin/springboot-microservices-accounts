package com.nerfilin.accounts.service.Impl;

import org.springframework.stereotype.Service;

import com.nerfilin.accounts.dto.CustomerDto;
import com.nerfilin.accounts.repository.AccountsRepository;
import com.nerfilin.accounts.repository.CustomerRepository;
import com.nerfilin.accounts.service.IAccountsService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AccountsServiceImpl implements IAccountsService {

    private AccountsRepository accountsRepository;
    private CustomerRepository customerRepository;

    @Override
    public void createAccount(CustomerDto customerDto) {
        
    }
    

}
