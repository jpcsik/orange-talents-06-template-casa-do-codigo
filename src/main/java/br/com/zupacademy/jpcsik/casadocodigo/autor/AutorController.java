package br.com.zupacademy.jpcsik.casadocodigo.autor;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AutorController {

	@Autowired
	private AutorRepository repository;
	
	@PostMapping(value="/novoAutor")
	@Transactional
	public ResponseEntity<?> cadastrar(@RequestBody @Valid NovoAutorRequest novoAutor) {
		repository.save(novoAutor.toAutor());
		return ResponseEntity.ok().build();
	}
	
}