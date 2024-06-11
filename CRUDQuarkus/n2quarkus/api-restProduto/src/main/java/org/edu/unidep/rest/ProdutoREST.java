package org.edu.unidep.rest;

import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.edu.unidep.model.Produto;
import org.edu.unidep.repository.ProdutoRepository;
import org.edu.unidep.service.ProdutoService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/produto")
public class ProdutoREST {

    private final ProdutoRepository produtoRepository;
    private final ProdutoService produtoService;

    @Inject
    public ProdutoREST(
            ProdutoRepository produtoRepository,
            ProdutoService produtoService) {
        this.produtoRepository = produtoRepository;
        this.produtoService = produtoService;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response listarProdutos() {
        List<Produto> produtos = produtoRepository.listarProdutos();
        return Response.ok(produtos).build();
    }

    @Path("/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Produto listarProdutoPeloCodigo(@PathParam("id") Long id){
        return produtoRepository.listarProdutoPeloCodigo(id);
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public void salvar(@RequestBody Produto produto){
        produtoRepository.salvar(produto);
    }

    @DELETE
    @Path("/{id}")
    public void excluir(@PathParam("id") Long id) {
        produtoRepository.excluir(id);
    }

    @PUT
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response atualizar(@PathParam("id") Long id,
                              @RequestBody Produto produto){
        Produto produtoAtualizado = produtoService.atualizar(id, produto);
        return Response.ok(produtoAtualizado).build();
    }
}
