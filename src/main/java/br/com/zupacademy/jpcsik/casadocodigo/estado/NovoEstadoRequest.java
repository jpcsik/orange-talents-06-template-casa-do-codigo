package br.com.zupacademy.jpcsik.casadocodigo.estado;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonCreator;

import br.com.zupacademy.jpcsik.casadocodigo.pais.Pais;
import br.com.zupacademy.jpcsik.casadocodigo.validacao.anotacoes.Existe;

public class NovoEstadoRequest {

	@NotBlank
	private String nome;
	@NotNull
	@Existe(fieldName = "id", domainClass = Pais.class)
	private Long idPais;
	
	@JsonCreator
	public NovoEstadoRequest(@NotBlank String nome, @NotNull Long idPais) {
		this.nome = nome;
		this.idPais = idPais;
	}

	public Estado toEstado(Pais pais) {
		return new Estado(this.nome, pais);
	}

	public Long getIdPais() {
		return idPais;
	}

	public String getNome() {
		return nome;
	}

}