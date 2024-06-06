package com.pet.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pet.entities.Proprietario;
import com.pet.repository.ProprietarioRepository;

@Service
public class ProprietarioService {
	
	private final ProprietarioRepository ProprietarioRepository;

	@Autowired
	public ProprietarioService(ProprietarioRepository ProprietarioRepository) {
		this.ProprietarioRepository = ProprietarioRepository;
	}

	public List<Proprietario> buscaTodosProprietario(){
		return ProprietarioRepository.findAll();
	}
	//@query
	public List<Proprietario> buscaPorNome(String Nome) {
		return ProprietarioRepository.findByNome(Nome);
	}
	
	//@query
		public List<Proprietario> buscaPorCpf(String cpf) {
			return ProprietarioRepository.findBycpf(cpf);
		} 
	public Proprietario buscaProprietarioId (Long id) {
		Optional <Proprietario> Proprietario = ProprietarioRepository.findById(id);
		return Proprietario.orElse(null);			
	}
	
	
		
	public Proprietario salvaProprietario(Proprietario Proprietario) {
		return ProprietarioRepository.save(Proprietario);
	}

		
	public Proprietario alterarProprietario(Long id, Proprietario alterarProprietario) {
		Optional <Proprietario> existeProprietario = ProprietarioRepository.findById(id);
		if (existeProprietario.isPresent()) {
			alterarProprietario.setId(id);
			return ProprietarioRepository.save(alterarProprietario);
		}
		return null;
	}

	public boolean apagarProprietario(Long id) {
		Optional <Proprietario> existeProprietario = ProprietarioRepository.findById(id);
		if (existeProprietario.isPresent()) {
			ProprietarioRepository.deleteById(id);
			return true;
		}
		return false;
	}
	
}