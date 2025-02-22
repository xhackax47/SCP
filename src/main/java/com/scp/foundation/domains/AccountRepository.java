package com.scp.foundation.domains;

import org.springframework.data.jpa.repository.JpaRepository;

import com.scp.foundation.models.Account;

public interface AccountRepository extends JpaRepository<Account, Long>{

}
