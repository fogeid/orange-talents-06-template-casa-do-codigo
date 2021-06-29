package br.com.zupacademy.diego.casadocodigo.repositories;

import br.com.zupacademy.diego.casadocodigo.models.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Long> {
    List<Autor> findByEmail(String email);
}
