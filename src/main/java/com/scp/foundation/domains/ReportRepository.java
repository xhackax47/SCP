package com.scp.foundation.domains;

import org.springframework.data.jpa.repository.JpaRepository;

import com.scp.foundation.models.Report;

public interface ReportRepository extends JpaRepository<Report, Long>{

}
