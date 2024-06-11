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

import com.pet.entities.Consulta;
import com.pet.service.ConsultaService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;


@Tag(name = "consulta", description = "API REST DE GERENCIAMENTO DE consulta")
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/consulta/")
public class ConsultaController {
		
		private final ConsultaService ConsultaService;

		@Autowired
		public ConsultaController(ConsultaService ConsultaService) {
			this.ConsultaService = ConsultaService;
		}

		@GetMapping ("/{id}")
		@Operation(summary = "Localiza uma consulta por id")
		public ResponseEntity<Consulta> buscaConsultaIdControlId (@ PathVariable Long id) {
			Consulta Consulta = ConsultaService.buscaConsultaId(id);
			if (Consulta != null) {
				return ResponseEntity.ok(Consulta);
			}
			else {
				return ResponseEntity.notFound().build();
			}
		}
		@GetMapping("/hora/{hora}")
		@Operation(summary = "Localiza uma consulta por hora")
		public List<Consulta> FindPorHora(@PathVariable String hora){
			return ConsultaService.BuscarPorHora(hora);
		}
		@GetMapping("/descricao/{descricao}")
		@Operation(summary = "Localiza uma consulta por descricao")
		public List<Consulta> FindbyDescricao(@PathVariable String descricao){
			return ConsultaService.ProcuraDescricao(descricao);
		}
		@GetMapping("/data/{data}")
		@Operation(summary = "Consulta todas as consultas por data")
		public ResponseEntity<List<Consulta>> buscarConsultasPorDataControl(@PathVariable String data){
			List<Consulta> Consulta = ConsultaService. ProcuraData(data);
			return ResponseEntity.ok(Consulta);
		}
		
		@GetMapping("/")
		@Operation(summary = "Apresenta todas as consultas")
		public ResponseEntity<List<Consulta>> buscaTodosConsultaControl(){
			List<Consulta> Consulta = ConsultaService.buscaTodosConsulta();
			return ResponseEntity.ok(Consulta);
		}
		
		@PostMapping("/")
		@Operation(summary = "Cadastra uma consulta ")
		public ResponseEntity<Consulta> salvaConsultaControl(@RequestBody  Consulta Consulta){
			Consulta salvaConsulta= ConsultaService.salvaConsulta(Consulta);
			return ResponseEntity.status(HttpStatus.CREATED).body(salvaConsulta);
		}
		@PutMapping("/{id}")
		@Operation(summary = "Altera uma consulta por id")
		public ResponseEntity<Consulta> alterarConsultaControl(@PathVariable Long id, @RequestBody Consulta Consulta){
			Consulta alterarConsulta = ConsultaService.alterarConsulta(id, Consulta);
			if(alterarConsulta != null) {
				return ResponseEntity.ok(alterarConsulta);
			}
			else {
				return ResponseEntity.notFound().build();
			}
		}
		@DeleteMapping("/{id}")
		@Operation(summary = "Deleta uma consulta por ID")
		public ResponseEntity<String> apagaConsultaControl(@PathVariable Long id){
			boolean Consulta = ConsultaService.apagarConsulta(id);
			if (Consulta) {
				return ResponseEntity.ok().body("O Consulta foi excluído com sucesso");
			}
			else {
				return ResponseEntity.notFound().build();
			}
		}
}