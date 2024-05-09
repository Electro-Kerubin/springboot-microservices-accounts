package com.nerfilin.accounts.service;

import com.nerfilin.accounts.dto.CustomerDto;



public interface IAccountsService {
    
    void createAccount(CustomerDto customerDto);

    CustomerDto fetchAccount(String mobileNumber);
    
    boolean updateAccount(CustomerDto customerDto);

    boolean deteleAccount(String mobileNumber);
}
