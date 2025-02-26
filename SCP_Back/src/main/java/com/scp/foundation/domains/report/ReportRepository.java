package com.scp.foundation.domains.report;

import org.springframework.data.jpa.repository.JpaRepository;

import com.scp.foundation.models.report.Report;

public interface ReportRepository extends JpaRepository<Report, Long> {}
