package com.scp.foundation.controllers.report;

import com.scp.foundation.enums.securitylevels.AccountSecurityLevel;

public record ReportDto(Long id, String name, String description, AccountSecurityLevel securityLevel) {}
