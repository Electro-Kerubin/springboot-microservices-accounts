package com.nerfilin.accounts.service;

import com.nerfilin.accounts.dto.CustomerDto;



public interface IAccountsService {
    
    void createAccount(CustomerDto customerDto);
}