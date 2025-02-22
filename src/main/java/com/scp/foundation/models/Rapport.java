package com.scp.foundation.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Rapport {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private String description;
	private Status securityLevel;

	public Rapport(String name, String description, Status securityLevel) {
		super();
		this.name = name;
		this.description = description;
		this.securityLevel = securityLevel;
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

	public Status getSecurityLevel() {
		return securityLevel;
	}

	public String getSecurityLevelName() {
		return securityLevel.name();
	}

	public void setSecurityLevel(Status securityLevel) {
		this.securityLevel = securityLevel;
	}
}
