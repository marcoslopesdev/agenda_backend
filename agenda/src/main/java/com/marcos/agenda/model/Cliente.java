package com.marcos.agenda.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDate;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tb_cliente")
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "O nome do cliente é obrigatório.")
	@Size(min = 3, max = 100, message = "O nome do cliente deve conter no mínimo 3 e no máximo 100 caracteres")
	private String nomeCliente;

	@NotBlank(message = "O CPF do cliente é obrigatório.")
	@Size(min = 11, max = 11, message = "O CPF do cliente deve conter 11 caracteres")
	@Column(unique = true)
	private String cpf;

	@Past(message = "Insira uma data válida! A data de nascimento deve ser uma data no passado.")
	private LocalDate dataNascimento;

	@Size(min = 5, max = 255, message = "O endereço do cliente deve conter no mínimo 5 e no máximo 255 caracteres")
	private String endereco;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cliente", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties("cliente")
	private List<Contato> contato;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public List<Contato> getContato() {
		return contato;
	}

	public void setContato(List<Contato> contato) {
		this.contato = contato;
	}

}