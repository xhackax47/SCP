package com.scp.foundation.controllers.account;

import com.scp.foundation.enums.securitylevels.AccountSecurityLevel;

public record AccountDto(Long id, String defaultEmail, String userName, AccountSecurityLevel status) {}
