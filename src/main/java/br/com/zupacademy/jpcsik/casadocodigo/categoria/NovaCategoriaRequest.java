package br.com.zupacademy.jpcsik.casadocodigo.categoria;

import javax.validation.constraints.NotBlank;

public class NovaCategoriaRequest {

	@NotBlank
	private String nome;
	
	@Deprecated
	public NovaCategoriaRequest() {
		
	}
	
	public NovaCategoriaRequest(@NotBlank String nome) {
		this.nome = nome;
	}

	public Categoria toCategoria() {
		Categoria categoria = new Categoria(this.nome);
		return categoria;
	}

	public String getNome() {
		return this.nome;
	}
	
}
