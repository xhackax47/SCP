package com.scp.foundation.exceptions;

public class UnauthorizedException extends RuntimeException {
	
    // Ajout du serialVersionUID pour éviter l'avertissement
    private static final long serialVersionUID = 1L;
    
    public UnauthorizedException(String message) {
        super(message);
    }
}