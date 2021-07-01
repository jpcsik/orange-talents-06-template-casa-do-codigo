package br.com.zupacademy.jpcsik.casadocodigo.estado;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonCreator;

import br.com.zupacademy.jpcsik.casadocodigo.pais.Pais;

public class NovoEstadoRequest {

	@NotBlank
	private String nome;
	@NotNull
	private Long pais;
	
	@JsonCreator
	public NovoEstadoRequest(@NotBlank String nome, @NotNull Long pais) {
		this.nome = nome;
		this.pais = pais;
	}

	public Estado toEstado(Pais pais) {
		return new Estado(this.nome, pais);
	}

	public Long getPais() {
		return pais;
	}

	public String getNome() {
		return nome;
	}

}