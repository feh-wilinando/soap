package br.com.caelum.fj36.spring.soap;

import br.com.caelum.fj36.webservice.ItemEstoque;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.util.HashMap;
import java.util.Map;

@Endpoint
public class EstoqueWSEndpoint {


    private static Map<String, ItemEstoque> repositorio = new HashMap<>();

    public EstoqueWSEndpoint() {

        ItemEstoque itemEstoque = new ItemEstoque();
        itemEstoque.setCodigo("SOA");
        itemEstoque.setQuantidade(32);

        repositorio.put("SOA", itemEstoque);
    }

    @PayloadRoot(namespace = "http://webservice.fj36.caelum.com.br/", localPart = "codigo")
    @ResponsePayload
    public ItemEstoque getItemEstoque(@RequestPayload String codigo) {

        return repositorio.get(codigo);
    }

}
