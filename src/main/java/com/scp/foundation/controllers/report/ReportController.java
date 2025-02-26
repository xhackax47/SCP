package com.scp.foundation.controllers.report;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.scp.foundation.domains.report.ReportRepository;
import com.scp.foundation.models.report.Report;

@RestController
public class ReportController {

	private final ReportRepository reportRepository;

	public ReportController(ReportRepository rapportRepository) {
		this.reportRepository = rapportRepository;
	}

	// Permet de récupérer la liste de tous les rapports
	@GetMapping("/reports")
	public List<Report> getAllReports() {
		return reportRepository.findAll();
	}

	// Permet de récupérer un rapport par son ID
	@GetMapping("/report/{id}")
	public ReportDto getReportById(@PathVariable Long id) {
		Report report = reportRepository.findById(id).orElseThrow();
		return new ReportDto(report.getId(), report.getName(), report.getDescription(), report.getSecurityLevel());
	}

	// Permet de créer un rapport
	@PostMapping("/report")
	public ReportDto createReport(@RequestBody ReportDto rapportDto) {
		Report report = reportRepository
				.save(new Report(rapportDto.name(), rapportDto.description(), rapportDto.securityLevel()));
		return new ReportDto(report.getId(), report.getName(), report.getDescription(), report.getSecurityLevel());
	}

	// Permet de modifier un rapport par son ID
	@PutMapping("/report/{id}")
	public Report modifyReport(@RequestBody Report reportModified, @PathVariable Long id) {
		return reportRepository.findById(id).map(report -> {
			report.setName(reportModified.getName());
			report.setDescription(reportModified.getDescription());
			report.setSecurityLevel(reportModified.getSecurityLevel());
			return reportRepository.save(report);
		}).orElseGet(() -> reportRepository.save(reportModified));
	}

	// Permet de supprimer un rapport par son ID
	@DeleteMapping("/report/{id}")
	public String deleteReport(@PathVariable Long id) {
		Report report = reportRepository.findById(id).orElseThrow();
		reportRepository.delete(report);
		return null;
	}
}
