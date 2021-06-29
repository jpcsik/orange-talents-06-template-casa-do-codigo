package br.com.zupacademy.jpcsik.casadocodigo.errovalidacao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import br.com.zupacademy.jpcsik.casadocodigo.autor.Autor;
import br.com.zupacademy.jpcsik.casadocodigo.autor.AutorRepository;
import br.com.zupacademy.jpcsik.casadocodigo.autor.NovoAutorRequest;

@Component
public class EmailRepetidoValidator implements Validator{

	@Autowired
	private AutorRepository repository;
	
	@Override
	public boolean supports(Class<?> clazz) {
		return NovoAutorRequest.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		if(errors.hasErrors()) {
			return;
		}
		NovoAutorRequest request = (NovoAutorRequest) target;
		Optional<Autor> email = repository.findByEmail(request.getEmail());
		
		if(email.isPresent()) {
			errors.rejectValue("email", null, "Email já cadastrado");
		}
	}

}
