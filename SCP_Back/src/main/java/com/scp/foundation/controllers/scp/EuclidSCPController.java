package com.scp.foundation.controllers.scp;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.scp.foundation.controllers.scp.dto.EuclidSCPDto;
import com.scp.foundation.domains.scp.EuclidSCPRepository;
import com.scp.foundation.models.scp.EuclidSCP;
import com.scp.foundation.models.scp.SCP;

@RestController
public class EuclidSCPController {

	private final EuclidSCPRepository scpRepository;

	public EuclidSCPController(EuclidSCPRepository scpRepository) {
		this.scpRepository = scpRepository;
	}

	// Permet de récupérer la liste de tous les SCP
	@GetMapping("/scps/euclid")
	public List<EuclidSCP> getAllSCP() {
		return scpRepository.findAll();
	}

	// Permet de récupérer un SCP par son ID
	@GetMapping("/scp/euclid/{id}")
	public EuclidSCPDto getSCPById(@PathVariable Long id) {
		EuclidSCP scp = scpRepository.findById(id).orElseThrow();
		return new EuclidSCPDto(scp.getId(), scp.getName(), scp.getDescription(), scp.getSecurityLevel());
	}

	// Permet de créer un SCP
	@PostMapping("/scp/euclid")
	public EuclidSCPDto createSCP(@RequestBody EuclidSCPDto scpDTO) {
		EuclidSCP scp = scpRepository.save(new EuclidSCP(scpDTO.name(), scpDTO.description(), scpDTO.securityLevel()));
		return new EuclidSCPDto(scp.getId(), scp.getName(), scp.getDescription(), scp.getSecurityLevel());
	}

	// Permet de modifier un SCP par son ID
	@PutMapping("/scp/euclid/{id}")
	public SCP modifySCP(@RequestBody EuclidSCP scpModified, @PathVariable Long id) {
		return scpRepository.findById(id).map(scp -> {
			scp.setName(scpModified.getName());
			scp.setDescription(scpModified.getDescription());
			return scpRepository.save(scp);
		}).orElseGet(() -> {
			return scpRepository.save(scpModified);
		});
	}

	// Permet de supprimer un SCP par son ID
	@DeleteMapping("/scp/euclid/{id}")
	public String deleteSCP(@PathVariable Long id) {
		EuclidSCP scp = scpRepository.findById(id).orElseThrow();
		scpRepository.delete(scp);
		return null;
	}
}
