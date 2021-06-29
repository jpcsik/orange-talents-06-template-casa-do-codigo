package br.com.zupacademy.jpcsik.casadocodigo.errovalidacao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import br.com.zupacademy.jpcsik.casadocodigo.categoria.Categoria;
import br.com.zupacademy.jpcsik.casadocodigo.categoria.CategoriaRepository;
import br.com.zupacademy.jpcsik.casadocodigo.categoria.NovaCategoriaRequest;

@Component
public class NomeRepetidoValidator implements Validator{

	@Autowired
	private CategoriaRepository repository;
	
	@Override
	public boolean supports(Class<?> clazz) {
		return NovaCategoriaRequest.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		if(errors.hasErrors()) {
			return;
		}
		NovaCategoriaRequest request = (NovaCategoriaRequest) target;
		Optional<Categoria> nome = repository.findByNome(request.getNome());
		
		if(nome.isPresent()) {
			errors.rejectValue("nome", null, "Categoria já cadastrada");
		}
	}

}
