package com.scp.foundation.models.scp;

import java.util.Objects;

import com.scp.foundation.enums.securitylevels.SCPSecurityLevel;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public final class SafeSCP extends SCP {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected Long id;
	protected String name;
	protected String description;
	protected SCPSecurityLevel securityLevel;

	public SafeSCP() {
		super();
	}

	public SafeSCP(String name, String description, SCPSecurityLevel securityLevel) {
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

	public SCPSecurityLevel getSecurityLevel() {
		return securityLevel;
	}

	public void setSecurityLevel(SCPSecurityLevel securityLevel) {
		this.securityLevel = securityLevel;
	}

	@Override
	public int hashCode() {
		return Objects.hash(description, id, name, securityLevel);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ThaumielSCP other = (ThaumielSCP) obj;
		return Objects.equals(description, other.description) && Objects.equals(id, other.id)
				&& Objects.equals(name, other.name) && securityLevel == other.securityLevel;
	}

	@Override
	public String toString() {
		return "SCP [name=" + name + ", description=" + description + ", securityLevel=" + securityLevel + "]";
	}
}
