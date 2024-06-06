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

import com.pet.entities.Pets;
import com.pet.service.PetService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;



@Tag(name = "pet", description = "API REST DE GERENCIAMENTO DE pet")
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/pet/")
public class PetController {
		
		private final PetService PetService;

		@Autowired
		public PetController(PetService PetService) {
			this.PetService = PetService;
		}

		@GetMapping ("/{id}")
		@Operation(summary = "Localiza um pet por ID")
		public ResponseEntity<Pets> buscaPetIdControlId (@ PathVariable Long id) {
			Pets Pet = PetService.buscaPetId(id);
			if (Pet != null) {
				return ResponseEntity.ok(Pet);
			}
			else {
				return ResponseEntity.notFound().build();
			}
		}
	
		@GetMapping("/nome/{nome}")
		@Operation(summary = "Localiza um pet por nome")
		public ResponseEntity<List<Pets>> buscarPetsPorNomeControl(@PathVariable String nome){
			List<Pets> Pet = PetService.buscaPorNome(nome);
			return ResponseEntity.ok(Pet);
		}
		@GetMapping("/ndocumento/{ndocumento}")
		@Operation(summary = "Localiza um pet por numero do documento")
		public ResponseEntity<List<Pets>> buscarPetsPorDocumento(@PathVariable String ndocumento){
			List<Pets> Pet = PetService.buscaPorDocumento(ndocumento);
			return ResponseEntity.ok(Pet);
		}
		
		
		@GetMapping("/")
		@Operation(summary = "apresenta todos os pets")
		public ResponseEntity<List<Pets>> buscaTodosPetControl(){
			List<Pets> Pet = PetService.buscaTodosPet();
			return ResponseEntity.ok(Pet);
		}
		
		@PostMapping("/")
		@Operation(summary = "cadastra um pet")
		public ResponseEntity<Pets> salvaPetControl(@RequestBody  Pets Pet){
			Pets salvaPet= PetService.salvaPet(Pet);
			return ResponseEntity.status(HttpStatus.CREATED).body(salvaPet);
		}
		@PutMapping("/{id}")
		@Operation(summary = "altera um pet por id")
		public ResponseEntity<Pets> alterarPetControl(@PathVariable Long id, @RequestBody Pets Pet){
			Pets alterarPet = PetService.alterarPet(id, Pet);
			if(alterarPet != null) {
				return ResponseEntity.ok(alterarPet);
			}
			else {
				return ResponseEntity.notFound().build();
			}
		}
		@DeleteMapping("/{id}")
		@Operation(summary = "deleta um pet por id")
		public ResponseEntity<String> apagaPetControl(@PathVariable Long id){
			boolean Pet = PetService.apagarPet(id);
			if (Pet) {
				return ResponseEntity.ok().body("O Pet foi excluído com sucesso");
			}
			else {
				return ResponseEntity.notFound().build();
			}
		}
}