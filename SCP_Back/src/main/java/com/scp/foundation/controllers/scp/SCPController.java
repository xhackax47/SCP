package com.scp.foundation.controllers.scp;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.scp.foundation.domains.scp.SCPRepository;
import com.scp.foundation.models.scp.SCP;

@RestController
public class SCPController {

	private final SCPRepository scpRepository;

	public SCPController(SCPRepository scpRepository) {
		this.scpRepository = scpRepository;
	}

    // Récupérer tous les SCP
	@GetMapping("/scps")
	public List<SCP> getAllSCP() {
		return scpRepository.findAll();
	}

    // Récupérer un SCP par ID
	@GetMapping("/scp/{id}")
    public SCPDto getSCPById(@PathVariable Long id) {
        SCP scp = scpRepository.findById(id).orElseThrow();
        return new SCPDto(scp.getId(), scp.getName(), scp.getDescription(), scp.getScpSecurityLevel(), scp.getAccountSecurityLevel());
    }

    // Créer un nouveau SCP
    @PostMapping
    public SCPDto createSCP(@RequestBody SCPDto scpDTO) {
        SCP scp = new SCP(scpDTO.name(), scpDTO.description(), scpDTO.scpSecurityLevel(), scpDTO.accountSecurityLevel());
        SCP savedScp = scpRepository.save(scp);
        return new SCPDto(savedScp.getId(), savedScp.getName(), savedScp.getDescription(), savedScp.getScpSecurityLevel(), savedScp.getAccountSecurityLevel());
    }

	// Permet de modifier un SCP par son ID
	@PutMapping("/scp/{id}")
	public SCP modifySCP(@RequestBody SCP scpModified, @PathVariable Long id) {
		return scpRepository.findById(id).map(scp -> {
			scp.setName(scpModified.getName());
			scp.setDescription(scpModified.getDescription());
			return scpRepository.save(scp);
		}).orElseGet(() -> {
			return scpRepository.save(scpModified);
		});
	}

	// Permet de supprimer un SCP par son ID
	@DeleteMapping("/scp/{id}")
	public String deleteSCP(@PathVariable Long id) {
		SCP scp = scpRepository.findById(id).orElseThrow();
		scpRepository.delete(scp);
		return null;
	}
}
