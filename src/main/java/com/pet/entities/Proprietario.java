package com.pet.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Proprietario")
public class Proprietario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id_Proprietario", nullable = false)
	private Long id;
	
	@Column(name = "nome", nullable = false, length = 100)
	private String nome;
	
	@Column(name = "cpf", nullable = false, length = 100)
	private String cpf;
	
	@Column(name = "rg", nullable = false, length = 100)
	private String rg;
	
	@Column(name = "estado", nullable = false, length = 100)
	private String estado;	
	
	@Column(name = "cidade", nullable = false, length = 100)
	private String cidade;
	
	@Column(name = "rua", nullable = false, length = 100)
	private String rua;
	
	@Column(name = "nCasa", nullable = false, length = 100)
	private String nCasa;
	
	@Column(name = "telefone1", nullable = false, length = 100)
	private String telefone1;
	
	@Column(name = "telefone2", nullable = false, length = 100)
	private String telefone2;
}
