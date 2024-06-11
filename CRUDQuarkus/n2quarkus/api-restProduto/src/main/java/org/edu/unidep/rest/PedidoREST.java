package org.edu.unidep.rest;

import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.edu.unidep.model.Orcamento;
import org.edu.unidep.model.Pedido;
import org.edu.unidep.repository.PedidoRepository;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Path("/pedido")
public class PedidoREST {

    private final PedidoRepository pedidoRepository;

    @Inject
    public PedidoREST(
            PedidoRepository pedidoRepository){
        this.pedidoRepository = pedidoRepository;

    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response listarPedidos(){
        List<Pedido> pedidos = pedidoRepository.listarPedidos();
        return Response.ok(pedidos).build();
    }

    @GET
    @Path("/cliente/{cliente}")
    @Produces(MediaType.APPLICATION_JSON)
    public Pedido listarPeloCliente(@PathParam("cliente") String cliente){
        return  pedidoRepository.listarPeloCliente(cliente);
    }

    @Path("/{pedidoId}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Pedido listarPedidoPeloCodigo(@PathParam("pedidoId") Long pedidoId){
        return pedidoRepository.listarPedidoPeloCodigo(pedidoId);
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public void criar(@RequestBody Pedido pedido){pedidoRepository.criar(pedido);}

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/data/{data_emissao}")
    public List<Pedido> listarPedidoPelaData(@PathParam ("data_emissao") String dt1){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate dt = LocalDate.parse(dt1.trim(), formatter);
        return pedidoRepository.listarPedidoPelaData(dt);
    }


}
