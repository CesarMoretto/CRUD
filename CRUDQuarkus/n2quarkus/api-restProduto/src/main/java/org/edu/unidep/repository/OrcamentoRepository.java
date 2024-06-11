package org.edu.unidep.repository;

import org.edu.unidep.model.Orcamento;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public interface OrcamentoRepository {

    public List<Orcamento> listarOrcamentos();

    Orcamento listarOrcamentoPeloCodigo(Long id);

public List<Orcamento> listarOrcamentoPelaData(LocalDate dt);

    public List<Orcamento> listarOrcamentosMaiores();

    void criar(Orcamento orcamento);
}
