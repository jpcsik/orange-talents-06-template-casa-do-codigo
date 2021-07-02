package br.com.zupacademy.jpcsik.casadocodigo.livro.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.jpcsik.casadocodigo.livro.Livro;
import br.com.zupacademy.jpcsik.casadocodigo.livro.LivroRepository;
import br.com.zupacademy.jpcsik.casadocodigo.livro.dto.DetalheLivroResponse;
import br.com.zupacademy.jpcsik.casadocodigo.livro.dto.ListaLivroResponse;

@RestController
@RequestMapping("/livro")
public class MostrarLivroController {

	@Autowired
	private LivroRepository livroRepository;
	
	@GetMapping("/listar")
	public List<ListaLivroResponse> listar(){
		List<Livro> lista = livroRepository.findAll();
		return ListaLivroResponse.converter(lista);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<DetalheLivroResponse> detalhar(@PathVariable Long id){
		Optional<Livro> livro = livroRepository.findById(id);
		if(livro.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(new DetalheLivroResponse(livro.get()));
	}
}