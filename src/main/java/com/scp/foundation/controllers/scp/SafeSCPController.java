package com.scp.foundation.controllers.scp;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.scp.foundation.controllers.scp.dto.SafeSCPDto;
import com.scp.foundation.domains.scp.SafeSCPRepository;
import com.scp.foundation.models.scp.SCP;
import com.scp.foundation.models.scp.SafeSCP;

@RestController
public class SafeSCPController {

	private final SafeSCPRepository scpRepository;

	public SafeSCPController(SafeSCPRepository scpRepository) {
		this.scpRepository = scpRepository;
	}

	// Permet de récupérer la liste de tous les SCP
	@GetMapping("/scps/safe")
	public List<SafeSCP> getAllSCP() {
		return scpRepository.findAll();
	}

	// Permet de récupérer un SCP par son ID
	@GetMapping("/scp/safe/{id}")
	public SafeSCPDto getSCPById(@PathVariable Long id) {
		SafeSCP scp = scpRepository.findById(id).orElseThrow();
		return new SafeSCPDto(scp.getId(), scp.getName(), scp.getDescription(), scp.getSecurityLevel());
	}

	// Permet de créer un SCP
	@PostMapping("/scp/safe")
	public SafeSCPDto createSCP(@RequestBody SafeSCPDto scpDTO) {
		SafeSCP scp = scpRepository.save(new SafeSCP(scpDTO.name(), scpDTO.description(), scpDTO.securityLevel()));
		return new SafeSCPDto(scp.getId(), scp.getName(), scp.getDescription(), scp.getSecurityLevel());
	}

	// Permet de modifier un SCP par son ID
	@PutMapping("/scp/safe/{id}")
	public SCP modifySCP(@RequestBody SafeSCP scpModified, @PathVariable Long id) {
		return scpRepository.findById(id).map(scp -> {
			scp.setName(scpModified.getName());
			scp.setDescription(scpModified.getDescription());
			return scpRepository.save(scp);
		}).orElseGet(() -> {
			return scpRepository.save(scpModified);
		});
	}

	// Permet de supprimer un SCP par son ID
	@DeleteMapping("/scp/safe/{id}")
	public String deleteSCP(@PathVariable Long id) {
		SafeSCP scp = scpRepository.findById(id).orElseThrow();
		scpRepository.delete(scp);
		return null;
	}
}
