package br.com.zupacademy.jpcsik.casadocodigo.livro.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.jpcsik.casadocodigo.autor.Autor;
import br.com.zupacademy.jpcsik.casadocodigo.autor.AutorRepository;
import br.com.zupacademy.jpcsik.casadocodigo.categoria.Categoria;
import br.com.zupacademy.jpcsik.casadocodigo.categoria.CategoriaRepository;
import br.com.zupacademy.jpcsik.casadocodigo.livro.LivroRepository;
import br.com.zupacademy.jpcsik.casadocodigo.livro.dto.NovoLivroRequest;

@RestController
public class NovoLivroController {

	@Autowired
	private LivroRepository livroRepository;
	
	@Autowired
	private CategoriaRepository categoriaRepository;

	@Autowired
	private AutorRepository autorRepository;
	
	@PostMapping("/livro/cadastrar")
	@Transactional
	public ResponseEntity<?> cadastrar(@RequestBody @Valid NovoLivroRequest novoLivro){
		
		Optional<Categoria> categoria = categoriaRepository.findById(novoLivro.getIdCategoria());
		Optional<Autor> autor = autorRepository.findById(novoLivro.getIdAutor());
		
		livroRepository.save(novoLivro.toLivro(categoria.get(),autor.get()));
		return ResponseEntity.ok().build();	
		
	}
	
}