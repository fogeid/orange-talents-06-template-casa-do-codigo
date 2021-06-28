package br.com.zupacademy.diego.casadocodigo.models;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Entity
@Table(name = "tb_autor")
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nome;

    @NotBlank
    @Email(message = "E-mail inválido.")
    private String email;

    @NotBlank
    @Length(max = 400)
    private String descricao;

    @CreationTimestamp
    private LocalDateTime dataCriacao;

    public Autor() {
    }

    public Autor(@NotBlank String nome, @NotBlank @Email(message = "E-mail inválido.") String email,
                 @NotBlank String descricao) {
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getDescricao() {
        return descricao;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }
}
