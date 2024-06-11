package org.edu.unidep.impl;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import org.edu.unidep.model.Produto;
import org.edu.unidep.repository.ProdutoRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class ProdutoImpl implements PanacheRepository<Produto>, ProdutoRepository {

    @Override
    public List<Produto> listarProdutos() {
        return listAll();
    }

    @Override
    public Produto listarProdutoPeloCodigo(Long id) {
        return findById(id);
    }

    @Transactional
    @Override
    public void salvar(Produto produto) {
        persist(produto);

    }
    @Transactional
    @Override
    public void excluir(Long id) {
        deleteById(id);

    }
}
