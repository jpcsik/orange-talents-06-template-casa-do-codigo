package br.com.zupacademy.jpcsik.casadocodigo.categoria;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonCreator.Mode;

import br.com.zupacademy.jpcsik.casadocodigo.validacao.anotacoes.ValorUnico;

public class NovaCategoriaRequest {

	@NotBlank
	@ValorUnico(fieldName = "nome", domainClass = Categoria.class)
	private String nome;
	
	@JsonCreator(mode = Mode.PROPERTIES)
	public NovaCategoriaRequest(@NotBlank String nome) {
		this.nome = nome;
	}

	public Categoria toCategoria() {
		Categoria categoria = new Categoria(this.nome);
		return categoria;
	}

}