package br.dev.aquila.simplegatewayhttp.api.v1.resources;

import java.util.Collections;
import java.util.Date;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import br.dev.aquila.simplegatewayhttp.api.v1.models.Produto;
import br.dev.aquila.simplegatewayhttp.api.v1.models.VendaReq;
import br.dev.aquila.simplegatewayhttp.api.v1.models.VendaResp;

@Path("/simplegatewayhttp/api/v1/vendas")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class VendasResource {

    @GET
    public Response getVendas(@PathParam("vendaId") String vandaId) {
        var venda = new VendaResp("V001", Collections.singletonList(new Produto("P001", "Arroz")), new Date());
        return Response.status(Status.OK)
                .entity(venda)
                .build();
    }

    @POST
    public Response postVendas(VendaReq venda) {
        var vendaResp = new VendaResp("V001",
                venda.getProdutos() != null ? venda.getProdutos() : Collections.emptyList(), new Date());
        return Response.status(Status.CREATED)
                .entity(vendaResp)
                .build();
    }
}