package br.com.zupacademy.diego.casadocodigo.dto;

import br.com.zupacademy.diego.casadocodigo.models.Categoria;
import br.com.zupacademy.diego.casadocodigo.validators.NomeUnico;

import javax.validation.constraints.NotBlank;

public class CategoriaFormDTO {
    @NomeUnico
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
