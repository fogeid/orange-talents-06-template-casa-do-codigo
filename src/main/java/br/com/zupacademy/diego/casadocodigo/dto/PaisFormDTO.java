package br.com.zupacademy.diego.casadocodigo.dto;

import br.com.zupacademy.diego.casadocodigo.models.Pais;
import br.com.zupacademy.diego.casadocodigo.validators.ValorUnico;

import javax.validation.constraints.NotBlank;

public class PaisFormDTO {
    @NotBlank
    @ValorUnico(obj = Pais.class, fieldName = "nome", message = "País já cadastrado, insera um outro país.")
    private String nome;

    public PaisFormDTO() {
    }

    public PaisFormDTO(@NotBlank String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Pais converter() {
        return new Pais(this.nome);
    }
}
