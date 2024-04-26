package com.nerfilin.accounts.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nerfilin.accounts.Entity.Customer;

public interface AccountsRepository extends JpaRepository<Customer, Long> {
    
}
