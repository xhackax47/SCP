package com.scp.foundation.controllers.scp;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.scp.foundation.controllers.scp.dto.KeterSCPDto;
import com.scp.foundation.domains.scp.KeterSCPRepository;
import com.scp.foundation.models.scp.KeterSCP;
import com.scp.foundation.models.scp.SCP;

@RestController
public class KeterSCPController {

	private final KeterSCPRepository scpRepository;

	public KeterSCPController(KeterSCPRepository scpRepository) {
		this.scpRepository = scpRepository;
	}

	// Permet de récupérer la liste de tous les SCP
	@GetMapping("/scps/keter")
	public List<KeterSCP> getAllSCP() {
		return scpRepository.findAll();
	}

	// Permet de récupérer un SCP par son ID
	@GetMapping("/scp/keter/{id}")
	public KeterSCPDto getSCPById(@PathVariable Long id) {
		KeterSCP scp = scpRepository.findById(id).orElseThrow();
		return new KeterSCPDto(scp.getId(), scp.getName(), scp.getDescription(), scp.getSecurityLevel());
	}

	// Permet de créer un SCP
	@PostMapping("/scp/keter")
	public KeterSCPDto createSCP(@RequestBody KeterSCPDto scpDTO) {
		KeterSCP scp = scpRepository.save(new KeterSCP(scpDTO.name(), scpDTO.description(), scpDTO.securityLevel()));
		return new KeterSCPDto(scp.getId(), scp.getName(), scp.getDescription(), scp.getSecurityLevel());
	}

	// Permet de modifier un SCP par son ID
	@PutMapping("/scp/keter/{id}")
	public SCP modifySCP(@RequestBody KeterSCP scpModified, @PathVariable Long id) {
		return scpRepository.findById(id).map(scp -> {
			scp.setName(scpModified.getName());
			scp.setDescription(scpModified.getDescription());
			return scpRepository.save(scp);
		}).orElseGet(() -> {
			return scpRepository.save(scpModified);
		});
	}

	// Permet de supprimer un SCP par son ID
	@DeleteMapping("/scp/keter/{id}")
	public String deleteSCP(@PathVariable Long id) {
		KeterSCP scp = scpRepository.findById(id).orElseThrow();
		scpRepository.delete(scp);
		return null;
	}
}
