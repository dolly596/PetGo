package com.pet.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pet.entities.TipoAnimal;
import com.pet.repository.TipoAnimalRepository;

@Service
public class TipoAnimalService {
	
	private final TipoAnimalRepository TipoAnimalRepository;

	@Autowired
	public TipoAnimalService(TipoAnimalRepository TipoAnimalRepository) {
		this.TipoAnimalRepository = TipoAnimalRepository;
	}

	public List<TipoAnimal> buscaTodosTipoAnimal(){
		return TipoAnimalRepository.findAll();
	}
	
	 //@query
	public List<TipoAnimal> buscaPorTipo(String tipo) {
		return TipoAnimalRepository.findByTipo(tipo);
	}
	

	public TipoAnimal buscaTipoAnimalId (Long id) {
		Optional <TipoAnimal> TipoAnimal = TipoAnimalRepository.findById(id);
		return TipoAnimal.orElse(null);			
	}
	
	
		
	public TipoAnimal salvaTipoAnimal(TipoAnimal TipoAnimal) {
		return TipoAnimalRepository.save(TipoAnimal);
	}

		
	public TipoAnimal alterarTipoAnimal(Long id, TipoAnimal alterarTipoAnimal) {
		Optional <TipoAnimal> existeTipoAnimal = TipoAnimalRepository.findById(id);
		if (existeTipoAnimal.isPresent()) {
			alterarTipoAnimal.setId(id);
			return TipoAnimalRepository.save(alterarTipoAnimal);
		}
		return null;
	}

	public boolean apagarTipoAnimal(Long id) {
		Optional <TipoAnimal> existeTipoAnimal = TipoAnimalRepository.findById(id);
		if (existeTipoAnimal.isPresent()) {
			TipoAnimalRepository.deleteById(id);
			return true;
		}
		return false;
	}
	
}