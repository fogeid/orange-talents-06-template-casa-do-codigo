package br.com.zupacademy.diego.casadocodigo.dto;

import br.com.zupacademy.diego.casadocodigo.models.Autor;
import br.com.zupacademy.diego.casadocodigo.validators.ValorUnico;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import java.time.LocalDateTime;

public class AutorFormDTO {
    @NotBlank
    private String nome;

    @NotBlank
    @ValorUnico(obj = Autor.class, fieldName = "email", message = "E-mail já cadastrado, insira um outro e-mail.")
    @Email(message = "E-mail inválido.")
    private String email;

    @NotBlank
    @Length(max = 400)
    private String descricao;

    public AutorFormDTO() {
    }

    public AutorFormDTO(@NotBlank String nome, @NotBlank @Email(message = "E-mail inválido.") String email,
                        @Length(max = 400) String descricao) {
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Autor converter() {
        return new Autor(this.nome, this.email, this.descricao);
    }
}
