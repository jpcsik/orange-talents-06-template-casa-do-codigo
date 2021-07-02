package br.com.zupacademy.jpcsik.casadocodigo.livro.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import br.com.zupacademy.jpcsik.casadocodigo.autor.Autor;
import br.com.zupacademy.jpcsik.casadocodigo.categoria.Categoria;
import br.com.zupacademy.jpcsik.casadocodigo.livro.Livro;
import br.com.zupacademy.jpcsik.casadocodigo.validacao.anotacoes.Existe;
import br.com.zupacademy.jpcsik.casadocodigo.validacao.anotacoes.ValorUnico;

public class NovoLivroRequest {

	@ValorUnico(fieldName = "titulo", domainClass = Livro.class)
	@NotBlank
	private String titulo;
	@Length(max = 500)
	@NotBlank
	private String resumo;
	@NotBlank
	private String sumario;
	@DecimalMin("20.00")
	@NotNull
	private BigDecimal preco;
	@Min(100)
	@NotNull
	private Integer numeroPaginas;
	@ValorUnico(fieldName = "isbn", domainClass = Livro.class)
	@NotNull
	private String isbn;
	@Future
	@JsonFormat(pattern = "dd/MM/yyyy", shape = Shape.STRING)
	private LocalDate dataPublicacao;
	@NotNull
	@Existe(fieldName = "id", domainClass = Categoria.class)
	private Long idCategoria;
	@NotNull
	@Existe(fieldName = "id", domainClass = Autor.class)
	private Long idAutor;
	
	
	@JsonCreator
	public NovoLivroRequest(@NotBlank String titulo, @Length(max = 500) @NotBlank String resumo,
			@NotBlank String sumario, @DecimalMin("20.00") @NotNull BigDecimal preco,
			@Min(100) @NotNull Integer numeroPaginas, @NotNull String isbn, @Future LocalDate dataPublicacao,
			@NotNull Long idCategoria, @NotNull Long idAutor) {
		this.titulo = titulo;
		this.resumo = resumo;
		this.sumario = sumario;
		this.preco = preco;
		this.numeroPaginas = numeroPaginas;
		this.isbn = isbn;
		this.dataPublicacao = dataPublicacao;
		this.idCategoria = idCategoria;
		this.idAutor = idAutor;
	}

	public Livro toLivro(Categoria categoria, Autor autor) {
		Livro livro = new Livro(
				this.titulo, 
				this.resumo, 
				this.sumario, 
				this.preco, 
				this.numeroPaginas, 
				this.isbn,
				this.dataPublicacao, 
				categoria,
				autor);
		return livro;
	}

	public Long getIdCategoria() {
		return this.idCategoria;
	}

	public Long getIdAutor() {
		return this.idAutor;
	}

}