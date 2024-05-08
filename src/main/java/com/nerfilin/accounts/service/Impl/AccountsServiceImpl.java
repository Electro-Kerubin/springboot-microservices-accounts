package com.nerfilin.accounts.service.Impl;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Random;

import org.springframework.stereotype.Service;

import com.nerfilin.accounts.Entity.Account;
import com.nerfilin.accounts.Entity.Customer;
import com.nerfilin.accounts.dto.AccountsDto;
import com.nerfilin.accounts.dto.CustomerDto;
import com.nerfilin.accounts.mapper.AccountsMapper;
import com.nerfilin.accounts.mapper.CustomerMapper;
import com.nerfilin.accounts.repository.AccountsRepository;
import com.nerfilin.accounts.repository.CustomerRepository;
import com.nerfilin.accounts.service.IAccountsService;
import com.nerfilin.accounts.util.AccountsConstants;
import com.nerfilin.accounts.util.exception.CustomerAlreadyExistsException;
import com.nerfilin.accounts.util.exception.ResourceNotFountException;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AccountsServiceImpl implements IAccountsService {

    private AccountsRepository accountsRepository;
    private CustomerRepository customerRepository;

    @Override
    public void createAccount(CustomerDto customerDto) {
        Customer customer = CustomerMapper.mapToCustomer(new Customer(), customerDto);
        Optional<Customer> optionalCustomer = customerRepository.findByMobileNumber(customerDto.getMobileNumber());

        if(optionalCustomer.isPresent()){
            throw new CustomerAlreadyExistsException("Customer already registered with given mobileNumber: " + customerDto.getMobileNumber());
        }
        customer.setCreatedAt(LocalDateTime.now());
        customer.setCreatedBy("AnonymousTest");
        Customer savedCustomer = customerRepository.save(customer);
        accountsRepository.save(createNewAccount(savedCustomer));
        }

    private Account createNewAccount(Customer customer) {
        Account newAccount = new Account();
        newAccount.setCustomerId(customer.getCustomerId());
        
        
        long randomAccNumber = 1000000000L + new Random().nextInt(900000000);
        newAccount.setAccountNumber(randomAccNumber);
        newAccount.setAccountType(AccountsConstants.SAVINGS);
        newAccount.setBranchAddress(AccountsConstants.ADDRESS);
        newAccount.setCreatedAt(LocalDateTime.now());
        newAccount.setCreatedBy("AnonymousTest");
        return newAccount;
    }

    @Override
    public CustomerDto fetchAccount(String mobileNumber) {
        // TODO Auto-generated method stub
        Customer customer = customerRepository.findByMobileNumber(mobileNumber).orElseThrow(
            ()->new ResourceNotFountException("Customer", "mobileNumber", mobileNumber)
        );

        Account account = accountsRepository.findByCustomerId(customer.getCustomerId()).orElseThrow(
            ()->new ResourceNotFountException("Account", "customerId", customer.getCustomerId().toString())
        );

        CustomerDto customerDto = CustomerMapper.mapToCustomerDto(customer, new CustomerDto());
        customerDto.setAccountsDto(AccountsMapper.mapToAccountsDto(account, new AccountsDto()));

        return customerDto;
    }
}
