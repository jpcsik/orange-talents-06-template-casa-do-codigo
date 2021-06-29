package br.com.zupacademy.jpcsik.casadocodigo.autor;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.jpcsik.casadocodigo.errovalidacao.EmailRepetidoValidator;

@RestController
public class AutorController {

	@Autowired
	private AutorRepository repository;
	@Autowired
	private EmailRepetidoValidator emailRepetidoValidator;
	
	@InitBinder
	public void init(WebDataBinder binder) {
		binder.addValidators(emailRepetidoValidator);
	}
	
	@PostMapping(value="/novoAutor")
	@Transactional
	public ResponseEntity<?> cadastrar(@RequestBody @Valid NovoAutorRequest novoAutor) {
		
		repository.save(novoAutor.toAutor());
		return ResponseEntity.ok().build();
	}
	
}