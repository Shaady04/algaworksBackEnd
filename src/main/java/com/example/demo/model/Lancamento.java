package com.example.demo.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
@Table(name = "lancamento")
public class Lancamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    @NotNull
    private String descricao;

    @NotNull
    @Column(name = "data_vencimento")
    private LocalDate dataVencimento;

    @Column(name = "data_pagamento")
    private  LocalDate dataPagamento;

    @NotNull
    private BigDecimal valor;
    private String observacao;

    @NotNull
    @Enumerated(EnumType.STRING)
    private TipoLancamento tipo;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "codigo_categoria")
    private Categoria categoria;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "codigo_pessoa")
    private Pessoa pessoa;


    /*Getters and setters*/
    public Long getCodigo(){return codigo;}
    public String getDescricao(){return descricao;}
    public LocalDate getDataVencimento(){return dataVencimento;}
    public LocalDate getDataPagamento(){return dataPagamento;}
    public BigDecimal getValor(){return valor;}
    public String getObservacao(){return observacao;}
    public Pessoa getPessoa(){return pessoa;}
    public Categoria getCategoria(){return categoria;}
    public TipoLancamento getTipo(){return tipo;}

    public void setCodigo(Long codigo){this.codigo = codigo;}
    public void setDescricao(String descricao){this.descricao = descricao;}
    public void setDataVencimento(LocalDate dataVencimento){this.dataVencimento = dataVencimento;}
    public void setDataPagamento(LocalDate dataPagamento){this.dataPagamento = dataPagamento;}
    public void setValor(BigDecimal valor){this.valor = valor;}
    public void setObservacao(String observacao){this.observacao = observacao;}
    public void setPessoa(Pessoa pessoa){this.pessoa = pessoa;}
    public void setCategoria(Categoria categoria){this.categoria = categoria;}
    public void setTipo(TipoLancamento tipo){this.tipo = tipo;}


    /*Equals and hashcode*/

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Lancamento)) return false;
        Lancamento that = (Lancamento) o;
        return Objects.equals(codigo, that.codigo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo);
    }




}
