package com.scp.foundation.controllers;

import com.scp.foundation.models.Status;

public record RapportDto(Long id, String name, String description, Status securityLevel) {

}
