package com.pet.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pet.entities.Consulta;
import com.pet.repository.ConsultaRepository;

@Service
public class ConsultaService {
	
	private final ConsultaRepository ConsultaRepository;

	@Autowired
	public ConsultaService(ConsultaRepository ConsultaRepository) {
		this.ConsultaRepository = ConsultaRepository;
	}

	public List<Consulta> buscaTodosConsulta(){
		return ConsultaRepository.findAll();
	}
	//@query
		public List <Consulta> BuscarPorHora (String hora) {
			return ConsultaRepository.findByHora(hora);
		}
	//@query
	public List<Consulta> ProcuraDescricao(String descricao) {
		return ConsultaRepository.findByDescricao(descricao);
	}
	//@query
	public List <Consulta> ProcuraHora (String hora) {
		return ConsultaRepository.findByHora(hora);
	}
	//@query
		public List <Consulta> ProcuraData (String data) {
			return ConsultaRepository.findByData(data);
		} 
	public Consulta buscaConsultaId (Long id) {
		Optional <Consulta> Consulta = ConsultaRepository.findById(id);
		return Consulta.orElse(null);			
	}
	
	
		
	public Consulta salvaConsulta(Consulta Consulta) {
		return ConsultaRepository.save(Consulta);
	}

		
	public Consulta alterarConsulta(Long id, Consulta alterarConsulta) {
		Optional <Consulta> existeConsulta = ConsultaRepository.findById(id);
		if (existeConsulta.isPresent()) {
			alterarConsulta.setId(id);
			return ConsultaRepository.save(alterarConsulta);
		}
		return null;
	}

	public boolean apagarConsulta(Long id) {
		Optional <Consulta> existeConsulta = ConsultaRepository.findById(id);
		if (existeConsulta.isPresent()) {
			ConsultaRepository.deleteById(id);
			return true;
		}
		return false;
	}
	
}