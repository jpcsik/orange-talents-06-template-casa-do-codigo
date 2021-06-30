package br.com.zupacademy.jpcsik.casadocodigo.livro;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import br.com.zupacademy.jpcsik.casadocodigo.autor.Autor;
import br.com.zupacademy.jpcsik.casadocodigo.categoria.Categoria;

@Entity
public class Livro {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(unique = true)
	@NotBlank
	private String titulo;
	@Length(max = 500)
	@Column(length = 500)
	@NotBlank
	private String resumo;
	@Column(columnDefinition = "TEXT")
	private String sumario;
	@DecimalMin("20.00")
	@NotNull
	private BigDecimal preco;
	@Min(100)
	@NotNull
	private Integer numeroPaginas;
	@Column(unique = true)
	@NotNull
	private Integer isbn;
	@Future
	private LocalDate dataPublicacao;
	@ManyToOne
	@NotNull
	private Categoria categoria;
	@ManyToOne
	@NotNull
	private Autor autor;

	@Deprecated
	public Livro() {
	}

	public Livro(@NotBlank String titulo, @Length(max = 500) @NotBlank String resumo, String sumario,
			@DecimalMin("20.00") @NotNull BigDecimal preco, @Min(100) @NotNull Integer numeroPaginas,
			@NotNull Integer isbn, @Future LocalDate dataPublicacao, @NotNull Categoria categoria,
			@NotNull Autor autor) {
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
	
	public Long getId() {
		return this.id;
	}

	public String getTitulo() {
		return this.titulo;
	}
}