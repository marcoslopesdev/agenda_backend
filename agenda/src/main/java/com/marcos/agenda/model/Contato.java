package com.marcos.agenda.model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tb_contato")
public class Contato {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "É obrigatório definir o tipo de contato.")
	@Size(min = 3, max = 50, message = "O tipo de contato deve conter no mínimo 03 e no máximo 50 caracteres.")
	private String tipo;

	@NotBlank(message = "É obrigatório definir o valor do contato.")
	@Size(min = 5, max = 100, message = "O valor do contato deve conter no mínimo 5 e no máximo 100 caracteres.")
	private String valor;

	@Size(max = 255, message = "A observação deve conter no máximo 255 caracteres.")
	private String observacao;

	@ManyToOne
	@JsonIgnoreProperties("contato")
	private Cliente cliente;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

}
