package br.com.zupacademy.diego.casadocodigo.dto;

import br.com.zupacademy.diego.casadocodigo.models.Autor;
import br.com.zupacademy.diego.casadocodigo.models.Categoria;
import br.com.zupacademy.diego.casadocodigo.models.Livro;

import java.time.LocalDate;

public class LivroDetalhesDTO {
    private String titulo;
    private String resumo;
    private String sumario;
    private Double preco;
    private Integer numeroPaginas;
    private String isbn;
    private LocalDate dataCriacao;
    private Categoria categoria;
    private Autor autor;

    public LivroDetalhesDTO() {
    }

    public LivroDetalhesDTO(Livro livro) {
        this.titulo = livro.getTitulo();
        this.resumo = livro.getResumo();
        this.sumario = livro.getSumario();
        this.preco = livro.getPreco();
        this.numeroPaginas = livro.getNumeroPaginas();
        this.isbn = livro.getIsbn();
        this.dataCriacao = livro.getDataPublicacao();
        this.categoria = livro.getCategoria();
        this.autor = livro.getAutor();
    }

    public String getTitulo() {
        return titulo;
    }

    public String getResumo() {
        return resumo;
    }

    public String getSumario() {
        return sumario;
    }

    public Double getPreco() {
        return preco;
    }

    public Integer getNumeroPaginas() {
        return numeroPaginas;
    }

    public String getIsbn() {
        return isbn;
    }

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public Autor getAutor() {
        return autor;
    }
}
