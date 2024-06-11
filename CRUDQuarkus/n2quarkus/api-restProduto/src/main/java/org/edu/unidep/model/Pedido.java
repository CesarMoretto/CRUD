package org.edu.unidep.model;

import io.smallrye.common.constraint.NotNull;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Pedido")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_pedido")
    private Long pedidoId;

    @ManyToOne
    @JoinColumn(name = "codigo_orcamento")
    private  Orcamento orcamento;

    @NotNull
    @Column(name = "data_emissao")
    private LocalDate dataEmissao;

    @NotNull
    @Column(name = "cliente")
    private String cliente;

    public Long getPedidoId() {
        return pedidoId;
    }

    public void setPedidoId(Long pedidoId) {
        this.pedidoId = pedidoId;
    }

    public Orcamento getOrcamento() {
        return orcamento;
    }

    public void setOrcamento(Orcamento orcamento) {
        this.orcamento = orcamento;
    }

    public LocalDate getDataEmissao() {
        return dataEmissao;
    }

    public void setDataEmissao(LocalDate dataEmissao) {
        this.dataEmissao = dataEmissao;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }
}
