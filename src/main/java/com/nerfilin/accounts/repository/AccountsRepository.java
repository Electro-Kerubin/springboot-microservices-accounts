package com.nerfilin.accounts.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nerfilin.accounts.Entity.Account;

public interface AccountsRepository extends JpaRepository<Account, Long> {
    
}
