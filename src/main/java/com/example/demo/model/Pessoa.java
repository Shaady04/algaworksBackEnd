package com.example.demo.model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Objects;

@Entity
@Table(name = "pessoa")
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    @NotNull
    @Size(min=3, max= 25)
    private String nome;

    /*ligacao com endereco*/
    @Embedded
    private Endereco endereco;

    @NotNull
    private boolean ativo;

    @JsonIgnore
    @Transient
    public boolean isInativo(){
        return !this.ativo;
    }

    /*getters and setters*/
    public Long getCodigo(){return codigo;}
    public String getNome(){return nome;}
    public boolean getAtivo(){return ativo;}

    public Endereco getEndereco(){return endereco;}

    public void setNome(){this.nome = nome;}
    public void setCodigo(){this.codigo = codigo;}
    public void setAtivo(Boolean ativo){this.ativo = this.ativo;}
    public void setEndereco(Endereco endereco){this.endereco = endereco;}


    /*HashCode and Equals*/
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pessoa)) return false;
        Pessoa pessoa = (Pessoa) o;
        return ativo == pessoa.ativo &&
                Objects.equals(codigo, pessoa.codigo) &&
                Objects.equals(nome, pessoa.nome) &&
                Objects.equals(endereco, pessoa.endereco);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo, nome, endereco, ativo);
    }






}
