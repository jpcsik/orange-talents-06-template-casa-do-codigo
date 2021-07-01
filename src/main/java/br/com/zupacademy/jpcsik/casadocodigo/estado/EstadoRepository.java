package br.com.zupacademy.jpcsik.casadocodigo.estado;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Long>{

	Optional<Estado> findByNomeAndPaisId(String nome, Long pais);
	
}