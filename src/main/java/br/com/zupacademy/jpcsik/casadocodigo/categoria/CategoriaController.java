package br.com.zupacademy.jpcsik.casadocodigo.categoria;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.jpcsik.casadocodigo.errovalidacao.NomeRepetidoValidator;

@RestController
public class CategoriaController {

	@Autowired
	private CategoriaRepository repository;
	
	@Autowired
	private NomeRepetidoValidator nomeRepetidoValidator;
	
	@InitBinder
	public void init(WebDataBinder binder) {
		binder.addValidators(nomeRepetidoValidator);
	}
	
	@PostMapping(value="/novaCategoria")
	@Transactional
	public ResponseEntity<?> cadastrar(@RequestBody @Valid NovaCategoriaRequest novaCategoria){
		repository.save(novaCategoria.toCategoria());
		return ResponseEntity.ok().build();
	}
	
}
