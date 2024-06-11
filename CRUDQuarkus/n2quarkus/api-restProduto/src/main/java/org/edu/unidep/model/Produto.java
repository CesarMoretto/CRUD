package org.edu.unidep.model;

import io.smallrye.common.constraint.NotNull;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Produto")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_produto")
    private Long id;

    @NotNull
    @Column(name = "nome", length = 80)
    private String nome;

    @NotNull
    @Column(name = "categoria", length = 80)
    private String descricao;

    @NotNull
    @Column(name = "ean", length = 13)
    private String ean;

    @NotNull
    @Column(name = "data_validade")
    private LocalDate dataVencimento;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getEan() {
        return ean;
    }

    public void setEan(String ean) {
        this.ean = ean;
    }

    public LocalDate getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(LocalDate dataVencimento) {
        this.dataVencimento = dataVencimento;
    }
}