package br.com.zupacademy.jpcsik.casadocodigo.pais;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonCreator.Mode;

import br.com.zupacademy.jpcsik.casadocodigo.validacao.anotacoes.ValorUnico;

public class NovoPaisRequest {

	@ValorUnico(fieldName = "nome", domainClass = Pais.class)
	@NotBlank
	private String nome;

	@JsonCreator(mode = Mode.PROPERTIES)
	public NovoPaisRequest(@NotBlank String nome) {
		this.nome = nome;
	}

	public Pais toPais() {
		return new Pais(this.nome);
	}

}