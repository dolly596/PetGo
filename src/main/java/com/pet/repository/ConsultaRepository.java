package com.pet.repository;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.pet.entities.Consulta;


public interface ConsultaRepository extends JpaRepository<Consulta,Long> {
	List<Consulta> findByHora(String hora);
	@Query("SELECT a FROM Consulta a WHERE a.descricao = :descricao")
	
	List<Consulta> findByDescricao(@Param("descricao") String descricao);
	
	@Query("SELECT a FROM Consulta a WHERE a.data = :data")
	List<Consulta> findByData (@Param("data") String data);

}
