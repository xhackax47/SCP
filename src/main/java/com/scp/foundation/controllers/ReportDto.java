package com.scp.foundation.controllers;

import com.scp.foundation.models.Status;

public record ReportDto(Long id, String name, String description, Status securityLevel) {

}
