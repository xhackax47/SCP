package com.scp.foundation.domains;

import org.springframework.data.jpa.repository.JpaRepository;

import com.scp.foundation.models.Rapport;

public interface RapportRepository extends JpaRepository<Rapport, Long>{

}
