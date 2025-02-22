package com.scp.foundation.controllers;

import com.scp.foundation.models.Status;

public record AccountDto(Long id, String defaultEmail, String userName, Status status) {

}
