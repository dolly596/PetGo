package com.pet.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;



import com.pet.entities.Especialidade;

public interface EspecialidadeRepository extends JpaRepository<Especialidade,Long> {
	   
	    //Query Methods
		List<Especialidade> findByNome(String nome);
	
}
