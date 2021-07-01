package br.com.zupacademy.diego.casadocodigo.dto;

import br.com.zupacademy.diego.casadocodigo.models.Cliente;
import br.com.zupacademy.diego.casadocodigo.models.Estado;
import br.com.zupacademy.diego.casadocodigo.models.Pais;
import br.com.zupacademy.diego.casadocodigo.repositories.EstadoRepository;
import br.com.zupacademy.diego.casadocodigo.repositories.PaisRepository;
import br.com.zupacademy.diego.casadocodigo.validators.NaoCadastrado;
import br.com.zupacademy.diego.casadocodigo.validators.ValorUnico;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Optional;

public class ClienteFormDTO {
    @NotBlank
    @Email
    @ValorUnico(obj = Cliente.class, fieldName = "email", message = "Este e-mail já foi cadastrado, insira um outro e-mail.")
    private String email;

    @NotBlank
    private String nome;

    @NotBlank
    private String sobrenome;

    @NotBlank
    @ValorUnico(obj = Cliente.class, fieldName = "documento", message = "CPF/CNPJ já cadastrado, insira um outro CPF/CNPJ.")
    private String documento;

    @NotBlank
    private String endereco;

    @NotBlank
    private String complemento;

    @NotBlank
    private String cidade;

    @NotNull
    @NaoCadastrado(obj = Pais.class, fieldName = "id", message = "Este país não está cadastrado.")
    private Long pais;

    @NaoCadastrado(obj = Estado.class, fieldName = "id", message = "Este estádo não está cadastrado.")
    private Long estado;

    @NotBlank
    private String telefone;

    @NotBlank
    private String cep;

    public ClienteFormDTO() {
    }

    public ClienteFormDTO(@NotBlank String email, @NotBlank String nome, @NotBlank String sobrenome, @NotBlank String documento, @NotBlank String endereco, @NotBlank String complemento, @NotBlank String cidade, @NotNull Long pais, @NotNull Long estado, @NotBlank String telefone, @NotBlank String cep) {
        this.email = email;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.documento = documento;
        this.endereco = endereco;
        this.complemento = complemento;
        this.cidade = cidade;
        this.pais = pais;
        this.estado = estado;
        this.telefone = telefone;
        this.cep = cep;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public Long getPais() {
        return pais;
    }

    public void setPais(Long pais) {
        this.pais = pais;
    }

    public Long getEstado() {
        return estado;
    }

    public void setEstado(Long estado) {
        this.estado = estado;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public Cliente converter(EstadoRepository estadoRepository, PaisRepository paisRepository) {
        Optional<Pais> pais = paisRepository.findById(this.pais);
        Estado estadoInstancia = null;
        if (this.estado != null) {
            estadoInstancia = estadoRepository.findById(this.estado).get();
        }

        return new Cliente(this.email, this.nome, this.sobrenome, this.documento, this.endereco,
                this.complemento, this.cidade, pais.get(), estadoInstancia, this.telefone, this.cep);
    }
}
