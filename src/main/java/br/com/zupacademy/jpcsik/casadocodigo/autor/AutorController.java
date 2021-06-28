package br.com.zupacademy.jpcsik.casadocodigo.autor;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AutorController {

	@PersistenceContext
	private EntityManager em;
	
	@PostMapping(value="/novoAutor")
	@Transactional
	public ResponseEntity<?> cadastrar(@RequestBody @Valid NovoAutorRequest novoAutor) {
		em.persist(novoAutor.toAutor());
		return ResponseEntity.ok().build();
	}
	
}