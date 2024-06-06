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

import com.pet.entities.Especialidade;
import com.pet.service.EspecialidadeService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;



@Tag(name = "especialidade", description = "API REST DE GERENCIAMENTO DE especialidade")
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/especialidade/")
public class EspecialidadeController {
		
		private final EspecialidadeService EspecialidadeService;

		@Autowired
		public EspecialidadeController(EspecialidadeService EspecialidadeService) {
			this.EspecialidadeService = EspecialidadeService;
		}

		@GetMapping ("/{id}")
		@Operation(summary = "Localiza uma especialidade por ID")
		public ResponseEntity<Especialidade> buscaEspecialidadeIdControlId (@ PathVariable Long id) {
			Especialidade Especialidade = EspecialidadeService.buscaEspecialidadeId(id);
			if (Especialidade != null) {
				return ResponseEntity.ok(Especialidade);
			}
			else {
				return ResponseEntity.notFound().build();
			}
		}
	
		@GetMapping("/nome/{nome}")
		@Operation(summary = "Localiza uma especialidade pelo nome")
		public ResponseEntity<List<Especialidade>> buscarEspecialidadesPorNomeControl(@PathVariable String nome){
			List<Especialidade> Especialidade = EspecialidadeService.buscaPorNome(nome);
			return ResponseEntity.ok(Especialidade);
		}
		
		
		@GetMapping("/")
		@Operation(summary = "Apresenta todas as especialidades")
		public ResponseEntity<List<Especialidade>> buscaTodosEspecialidadeControl(){
			List<Especialidade> Especialidade = EspecialidadeService.buscaTodosEspecialidade();
			return ResponseEntity.ok(Especialidade);
		}
		
		@PostMapping("/")
		@Operation(summary = "Cadastra as especialidades")
		public ResponseEntity<Especialidade> salvaEspecialidadeControl(@RequestBody  Especialidade Especialidade){
			Especialidade salvaEspecialidade= EspecialidadeService.salvaEspecialidade(Especialidade);
			return ResponseEntity.status(HttpStatus.CREATED).body(salvaEspecialidade);
		}
		@PutMapping("/{id}")
		@Operation(summary = "Altera as especialidades por id")
		public ResponseEntity<Especialidade> alterarEspecialidadeControl(@PathVariable Long id, @RequestBody Especialidade Especialidade){
			Especialidade alterarEspecialidade = EspecialidadeService.alterarEspecialidade(id, Especialidade);
			if(alterarEspecialidade != null) {
				return ResponseEntity.ok(alterarEspecialidade);
			}
			else {
				return ResponseEntity.notFound().build();
			}
		}
		@DeleteMapping("/{id}")
		@Operation(summary = "Deleta as especialidades por id")
		public ResponseEntity<String> apagaEspecialidadeControl(@PathVariable Long id){
			boolean Especialidade = EspecialidadeService.apagarEspecialidade(id);
			if (Especialidade) {
				return ResponseEntity.ok().body("O Especialidade foi excluído com sucesso");
			}
			else {
				return ResponseEntity.notFound().build();
			}
		}
}