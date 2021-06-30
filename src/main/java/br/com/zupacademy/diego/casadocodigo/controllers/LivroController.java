package br.com.zupacademy.diego.casadocodigo.controllers;

import br.com.zupacademy.diego.casadocodigo.dto.LivroDTO;
import br.com.zupacademy.diego.casadocodigo.dto.LivroFormDTO;
import br.com.zupacademy.diego.casadocodigo.models.Livro;
import br.com.zupacademy.diego.casadocodigo.repositories.AutorRepository;
import br.com.zupacademy.diego.casadocodigo.repositories.CategoriaRepository;
import br.com.zupacademy.diego.casadocodigo.repositories.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/livros")
public class LivroController {
    @Autowired
    private LivroRepository livroRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private AutorRepository autorRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<Livro> insert(@RequestBody @Valid LivroFormDTO dto) {
        Livro livro = dto.converter(categoriaRepository, autorRepository);
        livroRepository.save(livro);
        return ResponseEntity.ok(livro);
    }

    @GetMapping
    @Transactional
    public List<LivroDTO> findAll() {
        List<Livro> list = livroRepository.findAll();
        return LivroDTO.converter(list);
    }

}
