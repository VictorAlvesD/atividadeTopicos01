package br.unitins.topicos1.resource;

import java.util.List;

import br.unitins.topicos1.model.Livro;
import br.unitins.topicos1.repository.LivroRepository;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/livros")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class LivroResource {

    @Inject
    LivroRepository livroRepository;

    @POST
    @Transactional 
    public Livro insert(Livro livro){
        
        Livro novoEstado = new Livro();

        novoEstado.setNome(livro.getNome());
        novoEstado.setAutor(livro.getAutor());
        novoEstado.setEditora(livro.getEditora());
        novoEstado.setGenero(livro.getGenero());
        novoEstado.setIsbn(livro.getIsbn());

        livroRepository.persist(novoEstado);

        return novoEstado;
    }

    @GET
    public List<Livro> findAll() {
        return livroRepository.listAll();
    }
    @GET
    @Path("/{id}")
    public Livro findByID(@PathParam("id") Long id) {
        return livroRepository.findById(id);
    }
    @GET
    @Path("/search/nome/{nome}")
    public List<Livro> findByNome(@PathParam("nome") String nome) {
        return livroRepository.findByNome(nome);
    }
}
