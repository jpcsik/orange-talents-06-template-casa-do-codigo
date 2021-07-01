package br.com.zupacademy.jpcsik.casadocodigo.livro.dto;

import java.math.BigDecimal;

import br.com.zupacademy.jpcsik.casadocodigo.livro.Livro;

public class DetalheLivroResponse {
	
	private String titulo;
	private BigDecimal preco;
	private String resumo;
	private String sumario;
	private String nomeAutor;
	private String descricaoAutor;
	private Integer numeroPaginas;
	private String isbn;
	
	public DetalheLivroResponse(Livro livro) {
		this.titulo = livro.getTitulo();
		this.preco = livro.getPreco();
		this.resumo = livro.getResumo();
		this.sumario = livro.getSumario();
		this.nomeAutor = livro.getAutor().getNome();
		this.descricaoAutor = livro.getAutor().getDescricao();
		this.numeroPaginas = livro.getNumeroPaginas();
		this.isbn = livro.getIsbn();
	}
	
	public String getTitulo() {
		return titulo;
	}

	public BigDecimal getPreco() {
		return preco;
	}
	
	public String getResumo() {
		return resumo;
	}
	
	public String getSumario() {
		return sumario;
	}
	
	public Integer getNumeroPaginas() {
		return numeroPaginas;
	}
	
	public String getIsbn() {
		return isbn;
	}

	public String getNomeAutor() {
		return nomeAutor;
	}

	public String getDescricaoAutor() {
		return descricaoAutor;
	}
	
}