package br.com.zupacademy.diego.casadocodigo.dto;

public class ErroDeFormularioDTO {
    private String campo;
    private String erro;

    public ErroDeFormularioDTO(String campo, String erro) {
        this.campo = campo;
        this.erro = erro;
    }

    public String getCampo() {
        return campo;
    }

    public String getErro() {
        return erro;
    }
}
