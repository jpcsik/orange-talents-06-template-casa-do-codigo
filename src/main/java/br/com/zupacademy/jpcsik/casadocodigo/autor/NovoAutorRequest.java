package br.com.zupacademy.jpcsik.casadocodigo.autor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonCreator;

import br.com.zupacademy.jpcsik.casadocodigo.validacao.anotacoes.ValorUnico;

public class NovoAutorRequest {

	@NotBlank
	private String nome;
	@NotBlank
	@Email
	@ValorUnico(fieldName = "email", domainClass = Autor.class)
	private String email;
	@NotBlank
	@Size(max = 400)
	private String descricao;

	@JsonCreator
	public NovoAutorRequest(@NotBlank String nome, @NotBlank @Email String email,
			@NotBlank @Size(max = 400) String descricao) {
		this.nome = nome;
		this.email = email;
		this.descricao = descricao;
	}

	public Autor toAutor() {
		Autor autor = new Autor(this.nome, this.email, this.descricao);
		return autor;
	}

}