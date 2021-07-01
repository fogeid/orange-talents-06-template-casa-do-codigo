package br.com.zupacademy.diego.casadocodigo.dto;

import br.com.zupacademy.diego.casadocodigo.models.Estado;
import br.com.zupacademy.diego.casadocodigo.models.Pais;
import br.com.zupacademy.diego.casadocodigo.repositories.PaisRepository;
import br.com.zupacademy.diego.casadocodigo.validators.EstadoUnicoPorPais;
import br.com.zupacademy.diego.casadocodigo.validators.NaoCadastrado;
import br.com.zupacademy.diego.casadocodigo.validators.ValorUnico;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Optional;

@EstadoUnicoPorPais()
public class EstadoFormDTO {
    @NotBlank
    private String nome;

    @NotNull
    @NaoCadastrado(obj = Pais.class, fieldName = "id", message = "País não existe.")
    private Long pais;

    public EstadoFormDTO() {
    }

    public EstadoFormDTO(@NotBlank String nome, @NotNull Long pais) {
        this.nome = nome;
        this.pais = pais;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getPais() {
        return pais;
    }

    public void setPais(Long pais) {
        this.pais = pais;
    }

    public Estado converter(PaisRepository paisRepository) {
        Optional<Pais> pais = paisRepository.findById(this.pais);
        return new Estado(this.nome, pais.get());
    }
}
