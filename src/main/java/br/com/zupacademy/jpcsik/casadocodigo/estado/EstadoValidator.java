package br.com.zupacademy.jpcsik.casadocodigo.estado;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import br.com.zupacademy.jpcsik.casadocodigo.pais.Pais;
import br.com.zupacademy.jpcsik.casadocodigo.pais.PaisRepository;

@Component
public class EstadoValidator implements Validator{

	@Autowired
	private EstadoRepository estadoRepository;
	
	@Autowired
	private PaisRepository paisRepository;
	
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
		Optional<Pais> findById = paisRepository.findById(request.getPais());
		Optional<Estado> findByNomeAndPais = estadoRepository.findByNomeAndPaisId(request.getNome(), request.getPais());		
		
		if(findById.isEmpty()) {
			errors.rejectValue("pais", null, "País não está cadastrado");
		}if(findByNomeAndPais.isPresent()) {
			errors.rejectValue("nome", null, "Estado já cadastrado");
		}
	
	}

}