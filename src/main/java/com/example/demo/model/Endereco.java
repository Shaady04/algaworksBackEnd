package com.example.demo.model;

import org.aspectj.weaver.ast.Not;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Objects;

@Embeddable
public class Endereco {

    private String logradouro;
    private String numero;
    private String complemento;
    private String bairro;
    private String cep;
    private String cidade;
    private String estado;


    /*Getters and setters*/
    public String getLogradouro(){return logradouro;}
    public String getNumero(){return numero;}
    public String getComplemento(){return complemento;}
    public String getBairro(){return bairro;}
    public String getCep(){return cep;}
    public String getCidade(){return cidade;}
    public String getEstado(){return estado;}

    public void setLogradouro(String logradouro){this.logradouro = logradouro;}
    public void setNumero(String numero){this.numero = numero;}
    public void setComplemento(String complemento){this.complemento = complemento;}
    public void setBairro(String bairro){this.bairro = bairro;}
    public void setCep(String cep){this.cep = cep;}
    public void setCidade(String cidade){this.cidade = cidade;}
    public void setEstado(String estado){this.estado = estado;}


}
