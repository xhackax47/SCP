package com.scp.foundation.controllers;

import com.scp.foundation.enums.AccountSecurityLevel;

public record AccountDto(Long id, String defaultEmail, String userName, AccountSecurityLevel status) {

}
