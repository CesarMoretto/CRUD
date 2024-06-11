package org.edu.unidep.impl;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import org.edu.unidep.model.Pedido;
import org.edu.unidep.repository.PedidoRepository;


import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

@ApplicationScoped
public class PedidoImpl implements PanacheRepository<Pedido>, PedidoRepository {

    @Inject
    private EntityManager entityManager;

    @Override
    public List<Pedido> listarPedidos() {
        return listAll();
    }


    @Override
    public Pedido listarPeloCliente(String cliente) {
        String jpql = "SELECT c FROM Pedido c WHERE c.cliente = :cliente";

        return getEntityManager().createQuery(jpql, Pedido.class).setParameter("cliente", cliente)
                .getResultStream().findAny().orElseThrow();
    }


    @Override
    public Pedido listarPedidoPeloCodigo(Long pedidoId) {
        return findById(pedidoId);
    }


    @Override
    public List<Pedido> listarPedidoPelaData(LocalDate dataEmissao) {
        String jpql = "SELECT p FROM Pedido p WHERE p.dataEmissao = :dataEmissao";
        TypedQuery<Pedido> query = entityManager.createQuery(jpql, Pedido.class);
        query.setParameter("dataEmissao", dataEmissao);

        return query.getResultList();
    }


    @Transactional
    @Override
    public void criar(Pedido pedido) {
        persist(pedido);

    }


}
