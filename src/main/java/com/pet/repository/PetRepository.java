package com.pet.repository;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.pet.entities.Pets;

public interface PetRepository extends JpaRepository<Pets,Long> {
	   
	    //Query Methods
		List<Pets> findByNome(String nome);
		
		  //Query Methods
				List<Pets> findByndocumento(String nome);
	/*
		@Query("SELECT a FROM Pets a WHERE a.ndocumento = :ndocumento")
		List<Pets> findByNDocumento (@Param("ndocumento") String ndocumento); */
}