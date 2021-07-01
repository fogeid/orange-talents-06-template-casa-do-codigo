package br.com.zupacademy.diego.casadocodigo.controllers;

import br.com.zupacademy.diego.casadocodigo.dto.PaisFormDTO;
import br.com.zupacademy.diego.casadocodigo.models.Pais;
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
@RequestMapping("/pais")
public class PaisController {
    @Autowired
    private PaisRepository paisRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<Pais> inserir(@RequestBody @Valid PaisFormDTO dto) {
        Pais pais = dto.converter();
        paisRepository.save(pais);
        return ResponseEntity.ok(pais);
    }
}
