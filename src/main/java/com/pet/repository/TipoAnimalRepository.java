package com.pet.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;



import com.pet.entities.TipoAnimal;

public interface TipoAnimalRepository extends JpaRepository<TipoAnimal,Long> {
	   
	    //Query Methods
		List<TipoAnimal> findByTipo(String tipo);
	
}