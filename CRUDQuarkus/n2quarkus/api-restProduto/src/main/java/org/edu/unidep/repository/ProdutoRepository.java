package org.edu.unidep.repository;

import org.edu.unidep.model.Produto;

import java.util.List;

public interface ProdutoRepository {

    public List<Produto> listarProdutos();

    Produto listarProdutoPeloCodigo(Long id);

    void salvar(Produto produto);

    void excluir(Long id);
}
