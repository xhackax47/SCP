package com.scp.foundation.domains.account;

import org.springframework.data.jpa.repository.JpaRepository;

import com.scp.foundation.models.account.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {}
