package br.com.zupacademy.jpcsik.casadocodigo.livro;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.jpcsik.casadocodigo.autor.Autor;
import br.com.zupacademy.jpcsik.casadocodigo.autor.AutorRepository;
import br.com.zupacademy.jpcsik.casadocodigo.categoria.Categoria;
import br.com.zupacademy.jpcsik.casadocodigo.categoria.CategoriaRepository;

@RestController
public class LivroController {

	@Autowired
	private LivroRepository livroRepository;
	
	@Autowired
	private CategoriaRepository categoriaRepository;

	@Autowired
	private AutorRepository autorRepository;
	
	@PostMapping(value="/novoLivro")
	@Transactional
	public ResponseEntity<?> cadastrar(@RequestBody @Valid NovoLivroRequest novoLivro){
		
		Optional<Categoria> categoria = categoriaRepository.findById(novoLivro.getCategoria());
		Optional<Autor> autor = autorRepository.findById(novoLivro.getAutor());
		
		if(categoria.isEmpty()) {
			return ResponseEntity.badRequest().body("Categoria não existe!");
		}if(autor.isEmpty()) {
			return ResponseEntity.badRequest().body("Autor não existe!");
		}else{
			livroRepository.save(novoLivro.toLivro(categoria.get(),autor.get()));
			return ResponseEntity.ok().build();	
		}
	}
	
	@GetMapping(value="/listaLivros")
	public List<LivroResponse> listar(){
		List<Livro> lista = livroRepository.findAll();
		return LivroResponse.converter(lista);
	}
	
}