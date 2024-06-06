package com.pet.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Veterinario")
public class Veterinario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id_Veterinario", nullable = false)
	private Long id;
	
	@Column(name = "cpf", nullable = false, length = 100)
	private String cpf;
	
	@Column(name = "rg", nullable = false, length = 100)
	private String rg;
	
	@Column(name = "nome", nullable = false, length = 100)
	private String nome;
	
	@Column(name = "telefone", nullable = false, length = 100)
	private String telefone;
	
	@Column(name = "estado", nullable = false, length = 100)
	private String estado;
	
	@Column(name = "cidade", nullable = false, length = 100)
	private String cidade;
	
	@Column(name = "rua", nullable = false, length = 100)
	private String rua;
	
	@Column(name = "nCasa", nullable = false, length = 100)
	private String nCasa;
	
	@Column(name = "crmv", nullable = false, length = 100)
	private String crmv;
	
	@ManyToOne
	@JoinColumn(name = "Id_Especialidade")
	private Especialidade especialidade;
	
	
}
