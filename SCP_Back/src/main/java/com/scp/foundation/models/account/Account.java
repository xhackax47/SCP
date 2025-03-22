package com.scp.foundation.models.account;

import com.scp.foundation.enums.AccountSecurityLevel;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Account {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	protected String defaultEmail;
	protected String userName;
	protected String password;
	protected AccountSecurityLevel securityLevel;

	public Account() {
		super();
	}

	public Account(String defaultEmail, String userName, String password, AccountSecurityLevel securityLevel) {
		this.defaultEmail = defaultEmail;
		this.userName = userName;
		this.password = password;
		this.securityLevel = securityLevel;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public AccountSecurityLevel getSecurityLevel() {
		return securityLevel;
	}

	public String getSecurityLevelName() {
		return securityLevel.toString();
	}

	public void setSecurityLevel(AccountSecurityLevel securityLevel) {
		this.securityLevel = securityLevel;
	}
}
