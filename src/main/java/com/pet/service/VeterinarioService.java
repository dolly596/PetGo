package com.pet.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pet.entities.Veterinario;
import com.pet.repository.VeterinarioRepository;

@Service
public class VeterinarioService {
	
	private final VeterinarioRepository VeterinarioRepository;

	@Autowired
	public VeterinarioService(VeterinarioRepository VeterinarioRepository) {
		this.VeterinarioRepository = VeterinarioRepository;
	}

	public List<Veterinario> buscaTodosVeterinario(){
		return VeterinarioRepository.findAll();
	}
	 //@query
	public List<Veterinario> buscaPorCrmv(String crmv) {
		return VeterinarioRepository.findByCrmv(crmv);
	}
	//@query
		public List<Veterinario> buscaPorNome(String Nome) {
			return VeterinarioRepository.findByNome(Nome);
		} 
		

	public Veterinario buscaVeterinarioId (Long id) {
		Optional <Veterinario> Veterinario = VeterinarioRepository.findById(id);
		return Veterinario.orElse(null);			
	}
	
	
		
	public Veterinario salvaVeterinario(Veterinario Veterinario) {
		return VeterinarioRepository.save(Veterinario);
	}

		
	public Veterinario alterarVeterinario(Long id, Veterinario alterarVeterinario) {
		Optional <Veterinario> existeVeterinario = VeterinarioRepository.findById(id);
		if (existeVeterinario.isPresent()) {
			alterarVeterinario.setId(id);
			return VeterinarioRepository.save(alterarVeterinario);
		}
		return null;
	}

	public boolean apagarVeterinario(Long id) {
		Optional <Veterinario> existeVeterinario = VeterinarioRepository.findById(id);
		if (existeVeterinario.isPresent()) {
			VeterinarioRepository.deleteById(id);
			return true;
		}
		return false;
	}
	
}