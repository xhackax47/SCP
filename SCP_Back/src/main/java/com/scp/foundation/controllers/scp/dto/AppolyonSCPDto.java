package com.scp.foundation.controllers.scp.dto;

import com.scp.foundation.enums.securitylevels.SCPSecurityLevel;

public record AppolyonSCPDto(Long id, String name, String description, SCPSecurityLevel securityLevel) {}
