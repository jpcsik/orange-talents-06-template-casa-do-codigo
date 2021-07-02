package br.com.zupacademy.jpcsik.casadocodigo.cliente;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonCreator;

import br.com.zupacademy.jpcsik.casadocodigo.pais.Pais;
import br.com.zupacademy.jpcsik.casadocodigo.validacao.anotacoes.DocumentoValido;
import br.com.zupacademy.jpcsik.casadocodigo.validacao.anotacoes.Existe;
import br.com.zupacademy.jpcsik.casadocodigo.validacao.anotacoes.ValorUnico;

public class NovoClienteRequest {

	@NotBlank
	@Email
	@ValorUnico(fieldName = "email", domainClass = Cliente.class)
	private String email;
	@NotBlank
	private String nome;
	@NotBlank
	private String sobrenome;
	@DocumentoValido
	@ValorUnico(fieldName = "documento", domainClass = Cliente.class)
	private String documento;
	@NotBlank
	private String endereco;
	@NotBlank
	private String complemento;
	@NotBlank
	private String cidade;
	@NotNull
	@Existe(fieldName = "id", domainClass = Pais.class)
	private Long idPais;
	private Long idEstado;
	@NotBlank
	private String telefone;
	@NotBlank
	private String cep;
	
	@JsonCreator
	public NovoClienteRequest(@NotBlank @Email String email, @NotBlank String nome, @NotBlank String sobrenome,
			@NotNull String documento, @NotBlank String endereco, @NotBlank String complemento, @NotBlank String cidade,
			@NotNull Long idPais, Long idEstado, @NotBlank String telefone, @NotBlank String cep) {
		this.email = email;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.documento = documento;
		this.endereco = endereco;
		this.complemento = complemento;
		this.cidade = cidade;
		this.idPais = idPais;
		this.idEstado = idEstado;
		this.telefone = telefone;
		this.cep = cep;
	}

	public Cliente toCliente(Pais pais) {
		Cliente cliente = new Cliente(
				this.email,
				this.nome,
				this.sobrenome,
				this.documento,
				this.endereco,
				this.complemento,
				this.cidade,
				pais,
				this.telefone,
				this.cep
				);
		
		return cliente;
	}

	public Long getIdPais() {
		return this.idPais;
	}

	public Long getIdEstado() {
		return this.idEstado;
	}
	
}