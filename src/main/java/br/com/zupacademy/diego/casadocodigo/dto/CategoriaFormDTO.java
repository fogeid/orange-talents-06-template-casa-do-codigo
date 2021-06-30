package br.com.zupacademy.diego.casadocodigo.dto;

import br.com.zupacademy.diego.casadocodigo.models.Categoria;
import br.com.zupacademy.diego.casadocodigo.validators.ValorUnico;

import javax.validation.constraints.NotBlank;

public class CategoriaFormDTO {
    @ValorUnico(obj = Categoria.class, fieldName = "nome", message = "Categoria já cadastrada, insira uma outra categoria.")
    @NotBlank
    private String nome;

    public CategoriaFormDTO() {
    }

    public CategoriaFormDTO(@NotBlank String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Categoria converter() {
        return new Categoria(this.nome);
    }
}
