package org.edu.unidep.impl;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import org.edu.unidep.model.Orcamento;
import org.edu.unidep.repository.OrcamentoRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@ApplicationScoped
public class OrcamentoImpl implements PanacheRepository<Orcamento>, OrcamentoRepository {

    @Inject
    private EntityManager entityManager;

    @Override
    public List<Orcamento> listarOrcamentos() {
        return listAll();
    }

    @Override
    public Orcamento listarOrcamentoPeloCodigo(Long id) {
        return findById(id);
    }

    @Override
    public List<Orcamento> listarOrcamentoPelaData(LocalDate dt) {
        String jpql = "SELECT o FROM Orcamento o WHERE o.dt = :dt";
        TypedQuery<Orcamento> query = entityManager.createQuery(jpql, Orcamento.class);
        query.setParameter("dt", dt);

        return query.getResultList();
    }


    @Override
    public List<Orcamento> listarOrcamentosMaiores() {
        String jpql = "SELECT o FROM Orcamento o ORDER BY o.valor DESC";
        TypedQuery<Orcamento> query = entityManager.createQuery(jpql, Orcamento.class);
        return query.getResultList();
    }


    @Transactional
    @Override
    public void criar(Orcamento orcamento) {
        persist(orcamento);

    }
}
