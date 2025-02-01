package com.scp.foundation.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Account {
    @Id 
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String defaultEmail;
    private String userName;
    private Status status;
    
	public Account(String defaultEmail, String userName, Status status) {
		super();
		this.defaultEmail = defaultEmail;
		this.userName = userName;
		this.status = status;
	}
	
	public String getDefaultEmail() {
		return defaultEmail;
	}
	
	public void setDefaultEmail(String defaultEmail) {
		this.defaultEmail = defaultEmail;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public Status getStatus() {
		return status;
	}
	
	public void setStatus(Status status) {
		this.status = status;
	}
}
