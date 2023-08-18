package br.unitins.topicos1.resource;

import java.util.List;

import br.unitins.topicos1.model.Livro;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/livros")
public class LivroResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Livro> allLivros() {
        return Livro.listAll();
    }
}
