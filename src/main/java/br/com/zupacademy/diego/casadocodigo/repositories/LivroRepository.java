package br.com.zupacademy.diego.casadocodigo.repositories;

import br.com.zupacademy.diego.casadocodigo.models.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long> {
}
