package com.pet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pet.entities.Proprietario;
import com.pet.service.ProprietarioService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;



@Tag(name = "proprietario", description = "API REST DE GERENCIAMENTO DE proprietario")
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/proprietario/")
public class ProprietarioController {
		
		private final ProprietarioService ProprietarioService;

		@Autowired
		public ProprietarioController(ProprietarioService ProprietarioService) {
			this.ProprietarioService = ProprietarioService;
		}

		@GetMapping ("/{id}")
		@Operation(summary = "Localiza um proprietario por ID")
		public ResponseEntity<Proprietario> buscaProprietarioIdControlId (@ PathVariable Long id) {
			Proprietario Proprietario = ProprietarioService.buscaProprietarioId(id);
			if (Proprietario != null) {
				return ResponseEntity.ok(Proprietario);
			}
			else {
				return ResponseEntity.notFound().build();
			}
		}
	
		@GetMapping("/nome/{nome}")
		@Operation(summary = "Localiza um proprietario por nome")
		public ResponseEntity<List<Proprietario>> buscarProprietariosPorNomeControl(@PathVariable String nome){
			List<Proprietario> Proprietario = ProprietarioService.buscaPorNome(nome);
			return ResponseEntity.ok(Proprietario);
		}
		@GetMapping("/cpf/{cpf}")
		@Operation(summary = "Localiza um proprietario por cpf")
		public ResponseEntity<List<Proprietario>> buscarProprietariosPorCpfControl(@PathVariable String cpf){
			List<Proprietario> Proprietario = ProprietarioService.buscaPorCpf(cpf);
			return ResponseEntity.ok(Proprietario);
		}
		
		@GetMapping("/")
		@Operation(summary = "apresenta todos os proprietario")
		public ResponseEntity<List<Proprietario>> buscaTodosProprietarioControl(){
			List<Proprietario> Proprietario = ProprietarioService.buscaTodosProprietario();
			return ResponseEntity.ok(Proprietario);
		}
		
		@PostMapping("/")
		@Operation(summary = "cadastra um proprietario")
		public ResponseEntity<Proprietario> salvaProprietarioControl(@RequestBody  Proprietario Proprietario){
			Proprietario salvaProprietario= ProprietarioService.salvaProprietario(Proprietario);
			return ResponseEntity.status(HttpStatus.CREATED).body(salvaProprietario);
		}
		@PutMapping("/{id}")
		@Operation(summary = "altera um proprietario por ID")
		public ResponseEntity<Proprietario> alterarProprietarioControl(@PathVariable Long id, @RequestBody Proprietario Proprietario){
			Proprietario alterarProprietario = ProprietarioService.alterarProprietario(id, Proprietario);
			if(alterarProprietario != null) {
				return ResponseEntity.ok(alterarProprietario);
			}
			else {
				return ResponseEntity.notFound().build();
			}
		}
		@DeleteMapping("/{id}")
		@Operation(summary = "deleta um proprietario por ID")
		public ResponseEntity<String> apagaProprietarioControl(@PathVariable Long id){
			boolean Proprietario = ProprietarioService.apagarProprietario(id);
			if (Proprietario) {
				return ResponseEntity.ok().body("O Proprietario foi excluído com sucesso");
			}
			else {
				return ResponseEntity.notFound().build();
			}
		}
}