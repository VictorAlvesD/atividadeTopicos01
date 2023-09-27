package br.unitins.topicos1.service;

import java.util.List;

import br.unitins.topicos1.dto.LivroDTO;
import br.unitins.topicos1.dto.LivroResponseDTO;
import br.unitins.topicos1.model.Livro;
import br.unitins.topicos1.repository.LivroRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;
import jakarta.ws.rs.core.Response;

@ApplicationScoped
public class LivroServiceImpl implements LivroService {

    @Inject
    LivroRepository repository;

    @Override
    @Transactional
    public Response insert(LivroDTO dto) {
        try {
            // Cria um novo objeto Livro com base nos dados do DTO
            Livro novoLivro = new Livro();
            novoLivro.setNome(dto.nome());
            novoLivro.setAutor(dto.autor());
            novoLivro.setEditora(dto.editora());
            novoLivro.setGenero(dto.genero());
            novoLivro.setIsbn(dto.isbn());

            // Persiste o novo livro no repositório
            repository.persist(novoLivro);

            // Retorna uma resposta HTTP de sucesso
            return Response.ok(LivroResponseDTO.valueOf(novoLivro)).build();
        } catch (Exception e) {
            // Em caso de erro, retorna uma resposta HTTP de erro
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Erro ao inserir o livro: " + e.getMessage())
                    .build();
        }
    }

    @Override
    @Transactional
    public Response update(LivroDTO dto, Long id) {
        try {
            // Cria um novo objeto Livro com base nos dados do DTO
            Livro novoLivro = new Livro();
            novoLivro.setNome(dto.nome());
            novoLivro.setAutor(dto.autor());
            novoLivro.setEditora(dto.editora());
            novoLivro.setGenero(dto.genero());
            novoLivro.setIsbn(dto.isbn());

            // Persiste o novo livro no repositório
            repository.persist(novoLivro);

            // Retorna uma resposta HTTP de update
            return Response.status(Response.Status.NO_CONTENT).build();
        } catch (Exception e) {
            // Em caso de erro, retorna uma resposta HTTP de erro
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Erro ao atualizar " + e.getMessage())
                    .build();
        }
    }

    @Override
    @Transactional
    public Response delete(Long id) {
        try {
            // Cria um novo objeto Livro com base nos dados do DTO
            repository.deleteById(id);
            return Response.status(Response.Status.NO_CONTENT).build();
        } catch (Exception e) {
            // Em caso de não encrobtrar, retorna uma resposta HTTP de erro
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
            .entity("Erro ao remover o recurso: " + e.getMessage())
            .build();
        }
    }

    @Override
    public LivroResponseDTO findById(Long id) {
        return LivroResponseDTO.valueOf(repository.findById(id));
    }

    @Override
    public List<LivroResponseDTO> findByNome(String nome) {
        return repository.findByNome(nome).stream()
                .map(e -> LivroResponseDTO.valueOf(e)).toList();
    }

    @Override
    public List<LivroResponseDTO> findByAll() {
        return repository.listAll().stream()
                .map(e -> LivroResponseDTO.valueOf(e)).toList();
    }

}