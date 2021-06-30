package br.com.zupacademy.diego.casadocodigo.dto;

import br.com.zupacademy.diego.casadocodigo.models.Autor;
import br.com.zupacademy.diego.casadocodigo.models.Categoria;
import br.com.zupacademy.diego.casadocodigo.models.Livro;
import br.com.zupacademy.diego.casadocodigo.repositories.AutorRepository;
import br.com.zupacademy.diego.casadocodigo.repositories.CategoriaRepository;
import br.com.zupacademy.diego.casadocodigo.validators.NaoCadastrado;
import br.com.zupacademy.diego.casadocodigo.validators.ValorUnico;
import org.hibernate.validator.constraints.Length;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Optional;

public class LivroFormDTO {
    @NotBlank
    @ValorUnico(obj = Livro.class, fieldName = "titulo", message = "Título já cadastrado, insira um outro título.")
    private String titulo;

    @NotBlank
    @Length(max = 500)
    private String resumo;

    private String sumario;

    @NotNull
    @Min(value = 20)
    private Double preco;

    @NotNull
    @Min(value = 100)
    private Integer numeroPaginas;

    @NotBlank
    @ValorUnico(obj = Livro.class, fieldName = "isbn", message = "ISBN já cadastrado, insirá um outro ISBN.")
    private String isbn;

    @Future
    private LocalDate dataPublicacao;

    @NotNull
    @NaoCadastrado(obj = Categoria.class, fieldName = "id", message = "Categoria não existe.")
    private Long categoria;

    @NotNull
    @NaoCadastrado(obj = Autor.class, fieldName = "id", message = "Autor não existe.")
    private Long autor;

    public LivroFormDTO() {
    }

    public LivroFormDTO(@NotBlank String titulo, @NotBlank String resumo,
                 String sumario, @NotNull Double preco,
                 @NotNull Integer numeroPaginas, @NotBlank String isbn,
                 @Future LocalDate dataPublicacao,
                 @NotNull Long categoria, @NotNull Long autor) {
        this.titulo = titulo;
        this.resumo = resumo;
        this.sumario = sumario;
        this.preco = preco;
        this.numeroPaginas = numeroPaginas;
        this.isbn = isbn;
        this.dataPublicacao = dataPublicacao;
        this.categoria = categoria;
        this.autor = autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getResumo() {
        return resumo;
    }

    public void setResumo(String resumo) {
        this.resumo = resumo;
    }

    public String getSumario() {
        return sumario;
    }

    public void setSumario(String sumario) {
        this.sumario = sumario;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Integer getNumeroPaginas() {
        return numeroPaginas;
    }

    public void setNumeroPaginas(Integer numeroPaginas) {
        this.numeroPaginas = numeroPaginas;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public LocalDate getDataPublicacao() {
        return dataPublicacao;
    }

    public void setDataPublicacao(LocalDate dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }

    public Long getCategoria() {
        return categoria;
    }

    public void setCategoria(Long categoria) {
        this.categoria = categoria;
    }

    public Long getAutor() {
        return autor;
    }

    public void setAutor(Long autor) {
        this.autor = autor;
    }

    public Livro converter(CategoriaRepository categoriaRepository, AutorRepository autorRepository) throws ResponseStatusException {
        Optional<Categoria> categoria = categoriaRepository.findById(this.categoria);
        Optional<Autor> autor = autorRepository.findById(this.autor);
        return new Livro(this.titulo, this.resumo, this.sumario, this.preco,
                this.numeroPaginas, this.isbn, this.dataPublicacao, categoria.get(), autor.get());
    }
}
