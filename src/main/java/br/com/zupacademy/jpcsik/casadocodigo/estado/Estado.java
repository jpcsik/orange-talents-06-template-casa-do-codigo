package br.com.zupacademy.jpcsik.casadocodigo.estado;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;

import br.com.zupacademy.jpcsik.casadocodigo.pais.Pais;

@Entity
public class Estado {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank
	private String nome;
	@ManyToOne
	private Pais pais;
	
	@Deprecated
	public Estado() {
	}
	
	public Estado(@NotBlank String nome, Pais pais) {
		this.nome = nome;
		this.pais = pais;
	}

	public Boolean pertenceAoPais(Pais pais) {
		if(this.pais.getId() == pais.getId()) {
			return true;
		}return false;
	}
	
}