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

import com.pet.entities.TipoAnimal;
import com.pet.service.TipoAnimalService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;



@Tag(name = "tipoAnimal", description = "API REST DE GERENCIAMENTO DE tipoAnimal")
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/tipoanimal/")
public class TipoAnimalController {
		
		private final TipoAnimalService TipoAnimalService;

		@Autowired
		public TipoAnimalController(TipoAnimalService TipoAnimalService) {
			this.TipoAnimalService = TipoAnimalService;
		}

		@GetMapping ("/{id}")
		@Operation(summary = "Localiza um tipo de animal por ID")
		public ResponseEntity<TipoAnimal> buscaTipoAnimalIdControlId (@ PathVariable Long id) {
			TipoAnimal TipoAnimal = TipoAnimalService.buscaTipoAnimalId(id);
			if (TipoAnimal != null) {
				return ResponseEntity.ok(TipoAnimal);
			}
			else {
				return ResponseEntity.notFound().build();
			}
		}
	
		@GetMapping("/tipo/{tipo}")
		@Operation(summary = "Localiza um tipo de animal por tipo")
		public ResponseEntity<List<TipoAnimal>> buscarTipoAnimalsPorTipoControl(@PathVariable String tipo){
			List<TipoAnimal> TipoAnimal = TipoAnimalService.buscaPorTipo(tipo);
			return ResponseEntity.ok(TipoAnimal);
		}
		
		
		@GetMapping("/")
		@Operation(summary = "apresenta todos os tipos de animal")
		public ResponseEntity<List<TipoAnimal>> buscaTodosTipoAnimalControl(){
			List<TipoAnimal> TipoAnimal = TipoAnimalService.buscaTodosTipoAnimal();
			return ResponseEntity.ok(TipoAnimal);
		}
		
		@PostMapping("/")
		@Operation(summary = "cadastra um tipo de animal")
		public ResponseEntity<TipoAnimal> salvaTipoAnimalControl(@RequestBody  TipoAnimal TipoAnimal){
			TipoAnimal salvaTipoAnimal= TipoAnimalService.salvaTipoAnimal(TipoAnimal);
			return ResponseEntity.status(HttpStatus.CREATED).body(salvaTipoAnimal);
		}
		@PutMapping("/{id}")
		@Operation(summary = "altera um tipo de animal por ID")
		public ResponseEntity<TipoAnimal> alterarTipoAnimalControl(@PathVariable Long id, @RequestBody TipoAnimal TipoAnimal){
			TipoAnimal alterarTipoAnimal = TipoAnimalService.alterarTipoAnimal(id, TipoAnimal);
			if(alterarTipoAnimal != null) {
				return ResponseEntity.ok(alterarTipoAnimal);
			}
			else {
				return ResponseEntity.notFound().build();
			}
		}
		@DeleteMapping("/{id}")
		@Operation(summary = "deleta um tipo de animal por ID")
		public ResponseEntity<String> apagaTipoAnimalControl(@PathVariable Long id){
			boolean TipoAnimal = TipoAnimalService.apagarTipoAnimal(id);
			if (TipoAnimal) {
				return ResponseEntity.ok().body("O TipoAnimal foi excluído com sucesso");
			}
			else {
				return ResponseEntity.notFound().build();
			}
		}
}