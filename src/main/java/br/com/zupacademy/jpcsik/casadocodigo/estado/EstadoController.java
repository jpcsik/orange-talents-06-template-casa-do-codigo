package br.com.zupacademy.jpcsik.casadocodigo.estado;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.jpcsik.casadocodigo.pais.Pais;
import br.com.zupacademy.jpcsik.casadocodigo.pais.PaisRepository;

@RestController
public class EstadoController {

	@Autowired
	private EstadoRepository estadoRepository;

	@Autowired
	private PaisRepository paisRepository;
	
	@Autowired
	private EstadoValidator estadoValidator;
	
	@InitBinder
	public void init(WebDataBinder binder) {
		binder.addValidators(estadoValidator);
	}

	@PostMapping("/estado/cadastrar")
	@Transactional
	public ResponseEntity<?> cadastrar(@RequestBody @Valid NovoEstadoRequest novoEstado) {

		Optional<Pais> pais = paisRepository.findById(novoEstado.getPais());
		estadoRepository.save(novoEstado.toEstado(pais.get()));
		return ResponseEntity.ok().build();

	}
}