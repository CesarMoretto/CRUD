package org.edu.unidep.rest;

import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.edu.unidep.model.Orcamento;
import org.edu.unidep.repository.OrcamentoRepository;

import javax.inject.Inject;
import javax.persistence.MapKey;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Path("/orcamento")
public class OrcamentoREST {

    private final OrcamentoRepository orcamentoRepository;

    @Inject
    public OrcamentoREST(
            OrcamentoRepository orcamentoRepository){
        this.orcamentoRepository = orcamentoRepository;
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public void criar(@RequestBody Orcamento orcamento){orcamentoRepository.criar(orcamento);}

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response listarOrcamentos(){
        List<Orcamento> orcamentos = orcamentoRepository.listarOrcamentos();
        return Response.ok(orcamentos).build();
    }

    @Path("/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Orcamento listarOrcamentoPeloCodigo(@PathParam("id") Long id){
        return orcamentoRepository.listarOrcamentoPeloCodigo(id);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/data/{dt}")
    public List<Orcamento> listarOrcamentosPelaData(@PathParam ("dt") String dt1){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate dt = LocalDate.parse(dt1.trim(), formatter);
        return orcamentoRepository.listarOrcamentoPelaData(dt);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/valor")
    public List<Orcamento> listarOrcamentosMaiores(){
        return orcamentoRepository.listarOrcamentosMaiores();
    }


}

