package br.com.zupacademy.diego.casadocodigo.controllers;

import br.com.zupacademy.diego.casadocodigo.dto.LivroDTO;
import br.com.zupacademy.diego.casadocodigo.dto.LivroDetalhesDTO;
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
import java.util.Optional;

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
    public ResponseEntity<Livro> inserir(@RequestBody @Valid LivroFormDTO dto) {
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

    @GetMapping("/{id}")
    @Transactional
    public ResponseEntity<LivroDetalhesDTO> detalhesFindById(@PathVariable Long id) {
        Optional<Livro> livro = livroRepository.findById(id);
        if (livro.isPresent()) {
            return ResponseEntity.ok(new LivroDetalhesDTO(livro.get()));
        }

        return ResponseEntity.notFound().build();
    }
}
