package com.scp.foundation.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.scp.foundation.domains.SCPRepository;
import com.scp.foundation.models.scp.SCP;

@RestController
public class SCPController {
	
	private final SCPRepository scpRepository;
	
	public SCPController(SCPRepository scpRepository) {
		this.scpRepository = scpRepository;
	}
	
	// Permet de récupérer la liste de tous les SCP
	@GetMapping("/scps")
	public List<SCP> getAllSCP() {
		return scpRepository.findAll();
	}
	
	// Permet de récupérer un SCP par son ID
	@GetMapping("/scp/{id}")
	public SCPDto getSCPById(@PathVariable Long id) {
		SCP scp = scpRepository.findById(id).orElseThrow();
		return new SCPDto(scp.getId(), scp.getName(), scp.getDescription());
	}	
	
	// Permet de créer un SCP
	@PostMapping("/scp")
	public SCPDto createSCP(@RequestBody SCPDto scpDTO) {
		SCP scp = scpRepository.save(new SCP(scpDTO.name(), scpDTO.description()));
		return new SCPDto(scp.getId(), scp.getName(), scp.getDescription());
	}
	
	// Permet de modifier un SCP par son ID
	@PutMapping("/scp/{id}")
	public SCP modifySCP(@RequestBody SCP scpModified, @PathVariable Long id) {
		return scpRepository.findById(id)
				.map(scp -> { 
					scp.setName(scpModified.getName());
					scp.setDescription(scpModified.getDescription());
					return scpRepository.save(scp);
				})
				.orElseGet(() -> {
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
