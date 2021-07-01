package br.com.zupacademy.diego.casadocodigo.repositories;

import br.com.zupacademy.diego.casadocodigo.models.Estado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Long> {
    List<Estado> findByNomeAndPais_Id(String nomeEstado, Long nomePais);
}
