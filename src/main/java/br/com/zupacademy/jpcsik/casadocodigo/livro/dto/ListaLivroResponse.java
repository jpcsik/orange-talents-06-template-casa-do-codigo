package br.com.zupacademy.jpcsik.casadocodigo.livro.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.zupacademy.jpcsik.casadocodigo.livro.Livro;

public class ListaLivroResponse {

	private Long id;
	private String titulo;

	public ListaLivroResponse(Livro livro) {
		this.id = livro.getId();
		this.titulo = livro.getTitulo();
	}

	public Long getId() {
		return id;
	}

	public String getTitulo() {
		return titulo;
	}

	public static List<ListaLivroResponse> converter(List<Livro> lista) {
		return lista.stream().map(ListaLivroResponse::new).collect(Collectors.toList());
	}

}