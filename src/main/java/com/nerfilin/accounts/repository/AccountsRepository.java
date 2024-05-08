package com.nerfilin.accounts.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nerfilin.accounts.Entity.Account;

public interface AccountsRepository extends JpaRepository<Account, Long> {
    
    Optional<Account> findByCustomerId(Long customerId);
}
