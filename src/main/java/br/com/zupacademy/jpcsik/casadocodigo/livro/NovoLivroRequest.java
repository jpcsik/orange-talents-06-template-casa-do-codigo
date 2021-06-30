package br.com.zupacademy.jpcsik.casadocodigo.livro;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonCreator.Mode;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import br.com.zupacademy.jpcsik.casadocodigo.autor.Autor;
import br.com.zupacademy.jpcsik.casadocodigo.categoria.Categoria;
import br.com.zupacademy.jpcsik.casadocodigo.errovalidacao.ValorUnico;

public class NovoLivroRequest {

	@ValorUnico(fieldName = "titulo", domainClass = Livro.class)
	@NotBlank
	private String titulo;
	@Length(max = 500)
	@NotBlank
	private String resumo;
	private String sumario;
	@DecimalMin("20.00")
	@NotNull
	private BigDecimal preco;
	@Min(100)
	@NotNull
	private Integer numeroPaginas;
	@ValorUnico(fieldName = "isbn", domainClass = Livro.class)
	@NotNull
	private Integer isbn;
	@Future
	@JsonFormat(pattern = "dd/MM/yyyy", shape = Shape.STRING)
	private LocalDate dataPublicacao;
	@NotNull
	private Long categoria;
	@NotNull
	private Long autor;
	
	
	@JsonCreator(mode = Mode.PROPERTIES)
	public NovoLivroRequest(@NotNull String titulo, @Length(max = 500) String resumo, String sumario,
			@DecimalMin("20.00") BigDecimal preco, @Min(100) Integer numeroPaginas, Integer isbn,
			@Future LocalDate dataPublicacao, @NotNull Long categoria, @NotNull Long autor) {
		super();
		this.titulo = titulo;
		this.resumo = resumo;
		this.sumario = sumario;
		this.preco = preco;
		this.numeroPaginas = numeroPaginas;
		this.isbn = isbn;
		this.dataPublicacao = dataPublicacao;
		this.categoria = categoria;
		this.autor = autor;
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

	public Long getCategoria() {
		return this.categoria;
	}

	public Long getAutor() {
		return this.autor;
	}

}