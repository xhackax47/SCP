package com.scp.foundation.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Account {
    @Id 
    private Long id;
    private String defaultEmail;
    
	public Account(Long id, String defaultEmail) {
		super();
		this.id = id;
		this.defaultEmail = defaultEmail;
	}
	
	public String getDefaultEmail() {
		return defaultEmail;
	}
	public void setDefaultEmail(String defaultEmail) {
		this.defaultEmail = defaultEmail;
	}
}