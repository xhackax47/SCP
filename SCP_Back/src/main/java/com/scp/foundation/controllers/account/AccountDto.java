package com.scp.foundation.controllers.account;

import com.scp.foundation.enums.AccountSecurityLevel;

public record AccountDto(Long id, String defaultEmail, String userName, String password, AccountSecurityLevel securityLevel) {}
