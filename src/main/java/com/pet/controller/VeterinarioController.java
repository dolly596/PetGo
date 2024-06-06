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

import com.pet.entities.Veterinario;
import com.pet.service.VeterinarioService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;



@Tag(name = "veterinario", description = "API REST DE GERENCIAMENTO DE veterinario")
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/veterinario/")
public class VeterinarioController {
		
		private final VeterinarioService VeterinarioService;

		@Autowired
		public VeterinarioController(VeterinarioService VeterinarioService) {
			this.VeterinarioService = VeterinarioService;
		}

		@GetMapping ("/{id}")
		@Operation(summary = "Localiza um veterinario por ID")
		public ResponseEntity<Veterinario> buscaVeterinarioIdControlId (@ PathVariable Long id) {
			Veterinario Veterinario = VeterinarioService.buscaVeterinarioId(id);
			if (Veterinario != null) {
				return ResponseEntity.ok(Veterinario);
			}
			else {
				return ResponseEntity.notFound().build();
			}
		}
	
		@GetMapping("/nome/{nome}")
		@Operation(summary = "Localiza um veterinario por nome")
		public ResponseEntity<List<Veterinario>> buscarVeterinariosPorNomeControl(@PathVariable String nome){
			List<Veterinario> Veterinario = VeterinarioService.buscaPorNome(nome);
			return ResponseEntity.ok(Veterinario);
		}
		@GetMapping("/crmv/{crmv}")
		@Operation(summary = "Localiza um veterinario por crmv")
		public ResponseEntity<List<Veterinario>> buscarVeterinariosPorCrmvControl(@PathVariable String crmv){
			List<Veterinario> Veterinario = VeterinarioService.buscaPorCrmv(crmv);
			return ResponseEntity.ok(Veterinario);
		}
		
		@GetMapping("/")
		@Operation(summary = "apresenta todos os veterinario")
		public ResponseEntity<List<Veterinario>> buscaTodosVeterinarioControl(){
			List<Veterinario> Veterinario = VeterinarioService.buscaTodosVeterinario();
			return ResponseEntity.ok(Veterinario);
		}
		
		@PostMapping("/")
		@Operation(summary = "cadastra um veterinario")
		public ResponseEntity<Veterinario> salvaVeterinarioControl(@RequestBody  Veterinario Veterinario){
			Veterinario salvaVeterinario= VeterinarioService.salvaVeterinario(Veterinario);
			return ResponseEntity.status(HttpStatus.CREATED).body(salvaVeterinario);
		}
		@PutMapping("/{id}")
		@Operation(summary = "altera um veterinario por ID")
		public ResponseEntity<Veterinario> alterarVeterinarioControl(@PathVariable Long id, @RequestBody Veterinario Veterinario){
			Veterinario alterarVeterinario = VeterinarioService.alterarVeterinario(id, Veterinario);
			if(alterarVeterinario != null) {
				return ResponseEntity.ok(alterarVeterinario);
			}
			else {
				return ResponseEntity.notFound().build();
			}
		}
		@DeleteMapping("/{id}")
		@Operation(summary = "deleta um veterinario por ID")
		public ResponseEntity<String> apagaVeterinarioControl(@PathVariable Long id){
			boolean Veterinario = VeterinarioService.apagarVeterinario(id);
			if (Veterinario) {
				return ResponseEntity.ok().body("O Veterinario foi excluído com sucesso");
			}
			else {
				return ResponseEntity.notFound().build();
			}
		}
}