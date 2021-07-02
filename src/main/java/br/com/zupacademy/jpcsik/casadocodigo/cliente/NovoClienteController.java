package br.com.zupacademy.jpcsik.casadocodigo.cliente;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.jpcsik.casadocodigo.estado.Estado;
import br.com.zupacademy.jpcsik.casadocodigo.estado.EstadoRepository;
import br.com.zupacademy.jpcsik.casadocodigo.pais.Pais;
import br.com.zupacademy.jpcsik.casadocodigo.pais.PaisRepository;

@RestController
public class NovoClienteController {

	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private PaisRepository paisRepository;
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	@PostMapping("/cliente/cadastrar")
	@Transactional
	public ResponseEntity<?> cadastrar(@RequestBody @Valid NovoClienteRequest novoCliente){
		
		Pais pais = paisRepository.findById(novoCliente.getIdPais()).get();

		if(novoCliente.getIdEstado() == null) {
			Cliente cliente = novoCliente.toCliente(pais);
			clienteRepository.save(cliente);
			return ResponseEntity.ok().body("Cliente de id: "+cliente.getId()+" cadastrado com sucesso!");
		}
			
		Optional<Estado> estado = estadoRepository.findById(novoCliente.getIdEstado());	
		
		if(estado.isPresent() && estado.get().pertenceAoPais(pais)) {
			Cliente cliente = novoCliente.toCliente(pais);
			cliente.setEstado(estado.get());
			clienteRepository.save(cliente);
			return ResponseEntity.ok().body("Cliente de id: "+cliente.getId()+" cadastrado com sucesso!");
		}
			
		return ResponseEntity.badRequest().body("Estado não está cadastrado no País selecionado!");
		
	}
	
}