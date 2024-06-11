package org.edu.unidep.service;

import org.edu.unidep.model.Produto;
import org.edu.unidep.repository.ProdutoRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

@ApplicationScoped
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    @Inject
    public ProdutoService(
            ProdutoRepository produtoRepository){
        this.produtoRepository = produtoRepository;
    }

    @Transactional
    public Produto atualizar(Long id, Produto produto){
        Produto produtoEncontrado = produtoRepository.listarProdutoPeloCodigo(id);
        produtoEncontrado.setNome(produto.getNome());
        produtoEncontrado.setDescricao(produto.getDescricao());
        produtoEncontrado.setEan(produto.getEan());
        produtoEncontrado.setDataVencimento(produto.getDataVencimento());

        return produtoEncontrado;
    }
}
