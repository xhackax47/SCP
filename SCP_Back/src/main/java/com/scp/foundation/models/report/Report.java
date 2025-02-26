package com.scp.foundation.models.report;

import com.scp.foundation.enums.securitylevels.AccountSecurityLevel;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Report {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private String description;
	private AccountSecurityLevel securityLevel;

	public Report() {
		super();
	}

	public Report(String name, String description, AccountSecurityLevel securityLevel) {
		super();
		this.name = name;
		this.description = description;
		this.securityLevel = securityLevel;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public AccountSecurityLevel getSecurityLevel() {
		return securityLevel;
	}

	public String getSecurityLevelName() {
		return securityLevel.name();
	}

	public void setSecurityLevel(AccountSecurityLevel securityLevel) {
		this.securityLevel = securityLevel;
	}
}
