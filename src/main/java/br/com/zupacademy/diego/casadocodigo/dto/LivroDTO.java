package br.com.zupacademy.diego.casadocodigo.dto;

import br.com.zupacademy.diego.casadocodigo.models.Livro;

import java.util.List;
import java.util.stream.Collectors;

public class LivroDTO {
    private Long id;
    private String titulo;

    public LivroDTO() {
    }

    public LivroDTO(Livro livro) {
        this.id = livro.getId();
        this.titulo = livro.getTitulo();
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public static List<LivroDTO> converter(List<Livro> list) {
        return list.stream().map(LivroDTO::new).collect(Collectors.toList());
    }
}
