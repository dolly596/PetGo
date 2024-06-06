package com.pet.repository;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.pet.entities.Proprietario;

public interface ProprietarioRepository extends JpaRepository<Proprietario,Long> {
	   
	    //Query Methods
		List<Proprietario> findByNome(String nome);
		
		@Query("SELECT a FROM Proprietario a WHERE a.cpf = :cpf")
		List<Proprietario> findBycpf (@Param("cpf") String cpf);
}