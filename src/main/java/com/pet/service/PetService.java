package com.pet.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pet.entities.Pets;
import com.pet.repository.PetRepository;

@Service
public class PetService {
	
	private final PetRepository PetRepository;

	@Autowired
	public PetService(PetRepository PetRepository) {
		this.PetRepository = PetRepository;
	}

	public List<Pets> buscaTodosPet(){
		return PetRepository.findAll();
	}
	
	//@query
	public List<Pets> buscaPorNome(String nome) {
		return PetRepository.findByNome(nome);
	}
	//@query
		public List<Pets> buscaPorDocumento(String ndocumento) {
			return PetRepository.findByndocumento(ndocumento);
		} 
	public Pets buscaPetId (Long id) {
		Optional <Pets> Pet = PetRepository.findById(id);
		return Pet.orElse(null);			
	}
	
	
		
	public Pets salvaPet(Pets Pet) {
		return PetRepository.save(Pet);
	}

		
	public Pets alterarPet(Long id, Pets alterarPet) {
		Optional <Pets> existePet = PetRepository.findById(id);
		if (existePet.isPresent()) {
			alterarPet.setId(id);
			return PetRepository.save(alterarPet);
		}
		return null;
	}

	public boolean apagarPet(Long id) {
		Optional <Pets> existePet = PetRepository.findById(id);
		if (existePet.isPresent()) {
			PetRepository.deleteById(id);
			return true;
		}
		return false;
	}
	
}