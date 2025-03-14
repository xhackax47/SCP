package com.scp.foundation.controllers.scp;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.scp.foundation.controllers.scp.dto.AppolyonSCPDto;
import com.scp.foundation.domains.scp.AppolyonSCPRepository;
import com.scp.foundation.models.scp.AppolyonSCP;
import com.scp.foundation.models.scp.SCP;

@RestController
public class AppolyonSCPController {

	private final AppolyonSCPRepository scpRepository;

	public AppolyonSCPController(AppolyonSCPRepository scpRepository) {
		this.scpRepository = scpRepository;
	}

	// Permet de récupérer la liste de tous les SCP
	@GetMapping("/scps/appolyon")
	public List<AppolyonSCP> getAllSCP() {
		return scpRepository.findAll();
	}

	// Permet de récupérer un SCP par son ID
	@GetMapping("/scp/appolyon/{id}")
	public AppolyonSCPDto getSCPById(@PathVariable Long id) {
		AppolyonSCP scp = scpRepository.findById(id).orElseThrow();
		return new AppolyonSCPDto(scp.getId(), scp.getName(), scp.getDescription(), scp.getSecurityLevel());
	}

	// Permet de créer un SCP
	@PostMapping("/scp/appolyon")
	public AppolyonSCPDto createSCP(@RequestBody AppolyonSCPDto scpDTO) {
		AppolyonSCP scp = scpRepository.save(new AppolyonSCP(scpDTO.name(), scpDTO.description(), scpDTO.securityLevel()));
		return new AppolyonSCPDto(scp.getId(), scp.getName(), scp.getDescription(), scp.getSecurityLevel());
	}

	// Permet de modifier un SCP par son ID
	@PutMapping("/scp/appolyon/{id}")
	public SCP modifySCP(@RequestBody AppolyonSCP scpModified, @PathVariable Long id) {
		return scpRepository.findById(id).map(scp -> {
			scp.setName(scpModified.getName());
			scp.setDescription(scpModified.getDescription());
			return scpRepository.save(scp);
		}).orElseGet(() -> {
			return scpRepository.save(scpModified);
		});
	}

	// Permet de supprimer un SCP par son ID
	@DeleteMapping("/scp/appolyon/{id}")
	public String deleteSCP(@PathVariable Long id) {
		AppolyonSCP scp = scpRepository.findById(id).orElseThrow();
		scpRepository.delete(scp);
		return null;
	}
}
