package br.com.zupacademy.diego.casadocodigo.controllers;

import br.com.zupacademy.diego.casadocodigo.dto.LivroFormDTO;
import br.com.zupacademy.diego.casadocodigo.models.Livro;
import br.com.zupacademy.diego.casadocodigo.repositories.AutorRepository;
import br.com.zupacademy.diego.casadocodigo.repositories.CategoriaRepository;
import br.com.zupacademy.diego.casadocodigo.repositories.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import javax.validation.Valid;

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

}
