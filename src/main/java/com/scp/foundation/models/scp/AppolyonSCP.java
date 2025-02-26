package com.scp.foundation.models.scp;

import com.scp.foundation.enums.securitylevels.SCPSecurityLevel;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public final class AppolyonSCP extends SCP {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected Long id;

	public AppolyonSCP() {
		super();
	}

	public AppolyonSCP(String name, String description, SCPSecurityLevel securityLevel) {
		super();
		this.name = name;
		this.description = description;
		this.securityLevel = securityLevel;
	}

}
