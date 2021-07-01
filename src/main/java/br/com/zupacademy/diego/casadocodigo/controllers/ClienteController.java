package br.com.zupacademy.diego.casadocodigo.controllers;

import br.com.zupacademy.diego.casadocodigo.dto.ClienteFormDTO;
import br.com.zupacademy.diego.casadocodigo.models.Cliente;
import br.com.zupacademy.diego.casadocodigo.repositories.ClienteRepository;
import br.com.zupacademy.diego.casadocodigo.repositories.EstadoRepository;
import br.com.zupacademy.diego.casadocodigo.repositories.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private EstadoRepository estadoRepository;

    @Autowired
    private PaisRepository paisRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<Cliente> inserir(@RequestBody @Valid ClienteFormDTO dto) {
        Cliente cliente = dto.converter(estadoRepository, paisRepository);
        clienteRepository.save(cliente);
        return ResponseEntity.ok(cliente);
    }
}
