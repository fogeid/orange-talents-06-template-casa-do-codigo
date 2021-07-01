package br.com.zupacademy.diego.casadocodigo.controllers;

import br.com.zupacademy.diego.casadocodigo.dto.CategoriaFormDTO;
import br.com.zupacademy.diego.casadocodigo.models.Categoria;
import br.com.zupacademy.diego.casadocodigo.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {
    @Autowired
    private CategoriaRepository categoriaRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<Categoria> inserir(@RequestBody @Valid CategoriaFormDTO dto) {
        Categoria categoria = dto.converter();
        categoriaRepository.save(categoria);
        return ResponseEntity.ok(categoria);
    }
}
