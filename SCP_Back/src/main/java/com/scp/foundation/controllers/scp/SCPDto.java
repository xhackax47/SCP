package com.scp.foundation.controllers.scp;

import com.scp.foundation.enums.AccountSecurityLevel;
import com.scp.foundation.enums.SCPSecurityLevel;

public record SCPDto(Long id, String name, String description, SCPSecurityLevel scpSecurityLevel, AccountSecurityLevel accountSecurityLevel) {}
