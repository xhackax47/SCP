package com.scp.foundation.models.scp;

import com.scp.foundation.enums.AccountSecurityLevel;
import com.scp.foundation.enums.SCPSecurityLevel;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class SCP {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String description;
    private SCPSecurityLevel scpSecurityLevel;
    private AccountSecurityLevel accountSecurityLevel;
        
	public SCP() {
		super();
	}

	public SCP(String name, String description, SCPSecurityLevel scpSecurityLevel,
			AccountSecurityLevel accountSecurityLevel) {
		super();
		this.name = name;
		this.description = description;
		this.scpSecurityLevel = scpSecurityLevel;
		this.accountSecurityLevel = accountSecurityLevel;
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

	public SCPSecurityLevel getScpSecurityLevel() {
		return scpSecurityLevel;
	}

	public void setScpSecurityLevel(SCPSecurityLevel scpSecurityLevel) {
		this.scpSecurityLevel = scpSecurityLevel;
	}

	public AccountSecurityLevel getAccountSecurityLevel() {
		return accountSecurityLevel;
	}

	public void setAccountSecurityLevel(AccountSecurityLevel accountSecurityLevel) {
		this.accountSecurityLevel = accountSecurityLevel;
	}
	
}
