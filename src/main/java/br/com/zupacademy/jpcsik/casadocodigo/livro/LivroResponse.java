package br.com.zupacademy.jpcsik.casadocodigo.livro;

import java.util.List;
import java.util.stream.Collectors;

public class LivroResponse {

	private Long id;
	private String titulo;

	public LivroResponse(Livro livro) {
		this.id = livro.getId();
		this.titulo = livro.getTitulo();
	}

	public Long getId() {
		return id;
	}

	public String getTitulo() {
		return titulo;
	}

	public static List<LivroResponse> converter(List<Livro> lista) {
		return lista.stream().map(LivroResponse::new).collect(Collectors.toList());
	}

}