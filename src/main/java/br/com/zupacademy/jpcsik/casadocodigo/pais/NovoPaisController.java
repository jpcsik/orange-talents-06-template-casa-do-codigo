package br.com.zupacademy.jpcsik.casadocodigo.pais;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NovoPaisController {

	@Autowired
	private PaisRepository paisRepository;
	
	@PostMapping("pais/cadastrar")
	@Transactional
	public ResponseEntity<?> cadastrar(@RequestBody @Valid NovoPaisRequest novoPais) {
		paisRepository.save(novoPais.toPais());
		return ResponseEntity.ok().build();
	}
	
}