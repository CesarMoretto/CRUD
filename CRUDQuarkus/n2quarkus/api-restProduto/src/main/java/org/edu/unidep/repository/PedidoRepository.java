package org.edu.unidep.repository;

import org.edu.unidep.model.Orcamento;
import org.edu.unidep.model.Pedido;

import java.time.LocalDate;
import java.util.List;

public interface PedidoRepository {

    public List<Pedido> listarPedidos();
    Pedido listarPeloCliente(String cliente);

    Pedido listarPedidoPeloCodigo(Long pedidoId);

    public List<Pedido> listarPedidoPelaData (LocalDate dataEmissao);

  void criar(Pedido pedido);
}
