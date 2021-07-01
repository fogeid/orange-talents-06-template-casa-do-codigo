package br.com.zupacademy.diego.casadocodigo.controllers;

import br.com.zupacademy.diego.casadocodigo.dto.EstadoFormDTO;
import br.com.zupacademy.diego.casadocodigo.models.Estado;
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
@RequestMapping("/estados")
public class EstadoController {
    @Autowired
    private EstadoRepository estadoRepository;

    @Autowired
    private PaisRepository paisRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<Estado> inserir(@RequestBody @Valid EstadoFormDTO dto) {
        Estado estado = dto.converter(paisRepository);
        estadoRepository.save(estado);
        return ResponseEntity.ok(estado);
    }
}
