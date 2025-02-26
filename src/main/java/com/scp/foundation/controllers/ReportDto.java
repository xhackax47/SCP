package com.scp.foundation.controllers;

import com.scp.foundation.enums.AccountSecurityLevel;

public record ReportDto(Long id, String name, String description, AccountSecurityLevel securityLevel) {

}
