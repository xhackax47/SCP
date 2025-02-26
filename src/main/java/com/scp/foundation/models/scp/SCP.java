package com.scp.foundation.models.scp;

import java.util.Objects;

import com.scp.foundation.enums.securitylevels.SCPSecurityLevel;

public sealed class SCP permits AppolyonSCP, EuclidSCP, KeterSCP, SafeSCP, ThaumielSCP {
	protected Long id;
	protected String name;
	protected String description;
	protected SCPSecurityLevel securityLevel;

	public SCP() {
		super();
	}

	public SCP(Long id, String name, String description, SCPSecurityLevel securityLevel) {
		super();
		this.id = id;
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
		return Objects.hash(description, name, securityLevel);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SCP other = (SCP) obj;
		return Objects.equals(description, other.description) && Objects.equals(name, other.name)
				&& securityLevel == other.securityLevel;
	}

	@Override
	public String toString() {
		return "SCP [name=" + name + ", description=" + description + ", securityLevel=" + securityLevel + "]";
	}
}
