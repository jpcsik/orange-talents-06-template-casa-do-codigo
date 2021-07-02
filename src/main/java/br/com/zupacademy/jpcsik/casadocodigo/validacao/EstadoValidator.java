package br.com.zupacademy.jpcsik.casadocodigo.validacao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import br.com.zupacademy.jpcsik.casadocodigo.estado.Estado;
import br.com.zupacademy.jpcsik.casadocodigo.estado.EstadoRepository;
import br.com.zupacademy.jpcsik.casadocodigo.estado.NovoEstadoRequest;

@Component
public class EstadoValidator implements Validator{

	@Autowired
	private EstadoRepository estadoRepository;
	
	@Override
	public boolean supports(Class<?> clazz) {
		return NovoEstadoRequest.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		if(errors.hasErrors()) {
			return;
		}
		
		NovoEstadoRequest request = (NovoEstadoRequest) target;
		Optional<Estado> findByNomeAndPais = estadoRepository.findByNomeAndPaisId(request.getNome(), request.getIdPais());		
		
		if(findByNomeAndPais.isPresent()) {
			errors.rejectValue("nome", null, "Estado já cadastrado");
		}
	
	}

}