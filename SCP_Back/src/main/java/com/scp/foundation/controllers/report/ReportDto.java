package com.scp.foundation.controllers.report;

import com.scp.foundation.enums.AccountSecurityLevel;

public record ReportDto(Long id, String name, String description, AccountSecurityLevel securityLevel) {}
