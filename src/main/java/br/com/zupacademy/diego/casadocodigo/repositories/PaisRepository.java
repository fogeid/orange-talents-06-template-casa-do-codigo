package br.com.zupacademy.diego.casadocodigo.repositories;

import br.com.zupacademy.diego.casadocodigo.models.Pais;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaisRepository extends JpaRepository<Pais, Long> {
}
