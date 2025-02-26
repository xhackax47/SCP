package com.scp.foundation.models;

import com.scp.foundation.enums.AccountSecurityLevel;

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
    private AccountSecurityLevel status;
    
    public Account(){
    	super();
    }
    
	public Account(String defaultEmail, String userName, AccountSecurityLevel status) {
		this.defaultEmail = defaultEmail;
		this.userName = userName;
		this.status = status;
	}
	
	public Long getId() {
		return id;
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
	
	public AccountSecurityLevel getStatus() {
		return status;
	}
	
	public String getStatusName() {
		return status.toString();
	}
	
	public void setStatus(AccountSecurityLevel status) {
		this.status = status;
	}
}
