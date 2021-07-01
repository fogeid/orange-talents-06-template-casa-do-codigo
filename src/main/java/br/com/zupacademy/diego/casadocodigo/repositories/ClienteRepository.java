package br.com.zupacademy.diego.casadocodigo.repositories;

import br.com.zupacademy.diego.casadocodigo.models.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
