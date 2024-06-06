package com.pet.entities;

import com.pet.entities.Pets;

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
@Table(name = "Pet")
public class Pets {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id_Pet", nullable = false)
	private Long id;
	
	@Column(name = "nome", nullable = false, length = 100)
	private String nome;
	
	@Column(name = "dtNascimento", nullable = false, length = 100)
	private String dtNascimento;
	
	@Column(name = "ndocumento", nullable = false, length = 100)
	private String ndocumento;
	
	@Column(name = "tipoanimal", nullable = false, length = 100)
	private String tipoanimal;
	
	@Column(name = "raca", nullable = false, length = 100)
	private String raca;
	
	@Column(name = "cor", nullable = false, length = 100)
	private String cor;
	
	@ManyToOne
	@JoinColumn(name = "Id_TipoAnimal")
	private TipoAnimal tipoAnimal;
	
	@ManyToOne
	@JoinColumn(name = "Id_Proprietario")
	private Proprietario proprietario;
	
	
	
}
