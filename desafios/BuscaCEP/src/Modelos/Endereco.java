package Modelos;

public class Endereco {

    private String cep;
    private String logradouro;
    private String bairro;
    private String localicdade;
    private String estado;

    public Endereco(String cep, String logradouro, String bairro, String localicdade, String estado) {
        this.cep = cep;
        this.logradouro = logradouro;
        this.bairro = bairro;
        this.localicdade = localicdade;
        this.estado = estado;
    }

    public Endereco(EnderecoViaCep enderecoViaCep) {

        this.cep = enderecoViaCep.cep();
        this.logradouro = enderecoViaCep.logradouro();
        this.bairro = enderecoViaCep.bairro();
        this.localicdade = enderecoViaCep.localidade();
        this.estado = enderecoViaCep.estado();

    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getLocalicdade() {
        return localicdade;
    }

    public void setLocalicdade(String localicdade) {
        this.localicdade = localicdade;
    }


    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Endereco{" +
                "cep='" + cep + '\'' +
                ", logradouro='" + logradouro + '\'' +
                ", bairro='" + bairro + '\'' +
                ", localicdade='" + localicdade + '\'' +
                ", estado='" + estado + '\'' +
                '}';
    }
}
