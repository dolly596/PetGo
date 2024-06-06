package com.pet.repository;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.pet.entities.Veterinario;

public interface VeterinarioRepository extends JpaRepository<Veterinario,Long> {
	   
	   //Query Methods
		List<Veterinario> findByNome(String Nome);
	
		@Query("SELECT a FROM veterinario a WHERE a.crmv = :crmv")
		List<Veterinario> findByCrmv (@Param("crmv") String crmv); 
}