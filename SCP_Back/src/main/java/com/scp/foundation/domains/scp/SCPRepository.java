package com.scp.foundation.domains.scp;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.scp.foundation.enums.SCPSecurityLevel;
import com.scp.foundation.models.scp.SCP;

public interface SCPRepository extends JpaRepository<SCP, Long> {
    //List<SCP> findBySCPSecurityLevel(SCPSecurityLevel scpSecurityLevel);
}
