package com.scp.foundation.controllers.scp;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.scp.foundation.controllers.scp.dto.ThaumielSCPDto;
import com.scp.foundation.domains.scp.ThaumielSCPRepository;
import com.scp.foundation.models.scp.SCP;
import com.scp.foundation.models.scp.ThaumielSCP;

@RestController
public class ThaumielSCPController {

	private final ThaumielSCPRepository scpRepository;

	public ThaumielSCPController(ThaumielSCPRepository scpRepository) {
		this.scpRepository = scpRepository;
	}

	// Permet de récupérer la liste de tous les SCP
	@GetMapping("/scps/thaumiel")
	public List<ThaumielSCP> getAllSCP() {
		return scpRepository.findAll();
	}

	// Permet de récupérer un SCP par son ID
	@GetMapping("/scp/thaumiel/{id}")
	public ThaumielSCPDto getSCPById(@PathVariable Long id) {
		ThaumielSCP scp = scpRepository.findById(id).orElseThrow();
		return new ThaumielSCPDto(scp.getId(), scp.getName(), scp.getDescription(), scp.getSecurityLevel());
	}

	// Permet de créer un SCP
	@PostMapping("/scp/thaumiel")
	public ThaumielSCPDto createSCP(@RequestBody ThaumielSCPDto scpDTO) {
		ThaumielSCP scp = scpRepository.save(new ThaumielSCP(scpDTO.name(), scpDTO.description(), scpDTO.securityLevel()));
		return new ThaumielSCPDto(scp.getId(), scp.getName(), scp.getDescription(), scp.getSecurityLevel());
	}

	// Permet de modifier un SCP par son ID
	@PutMapping("/scp/thaumiel/{id}")
	public SCP modifySCP(@RequestBody ThaumielSCP scpModified, @PathVariable Long id) {
		return scpRepository.findById(id).map(scp -> {
			scp.setName(scpModified.getName());
			scp.setDescription(scpModified.getDescription());
			return scpRepository.save(scp);
		}).orElseGet(() -> {
			return scpRepository.save(scpModified);
		});
	}

	// Permet de supprimer un SCP par son ID
	@DeleteMapping("/scp/thaumiel/{id}")
	public String deleteSCP(@PathVariable Long id) {
		ThaumielSCP scp = scpRepository.findById(id).orElseThrow();
		scpRepository.delete(scp);
		return null;
	}
}
