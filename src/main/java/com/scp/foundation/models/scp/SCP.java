package com.scp.foundation.models.scp;

import java.util.Objects;

import com.scp.foundation.enums.securitylevels.SCPSecurityLevel;

public sealed class SCP permits AppolyonSCP, EuclidSCP, KeterSCP, SafeSCP, ThaumielSCP {
	
	public SCP() {
		super();
	}

}
