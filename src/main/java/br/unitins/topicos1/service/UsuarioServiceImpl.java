package br.unitins.topicos1.service;

import java.util.List;

import br.unitins.topicos1.dto.UsuarioDTO;
import br.unitins.topicos1.dto.UsuarioResponseDTO;
import br.unitins.topicos1.model.Usuario;
import br.unitins.topicos1.repository.UsuarioRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.core.Response;

@ApplicationScoped
public class UsuarioServiceImpl implements UsuarioService {

    @Inject
    UsuarioRepository repository;

    @Override
    @Transactional
    public Response insert(UsuarioDTO dto) {
        try {
            // Cria um novo objeto Usuario com base nos dados do DTO
            Usuario novoUsuario = new Usuario();
            novoUsuario.setNome(dto.nome());
            novoUsuario.setCpf(dto.cpf());
            novoUsuario.setLogin(dto.login());
            novoUsuario.setSenha(dto.senha());

            // Verifica se o login já existe no banco de dados
            Usuario user = (Usuario) repository.findByLogin(novoUsuario.getLogin());
            if (user != null) {
                return Response.status(Response.Status.BAD_REQUEST)
                        .entity("O login já está em uso.")
                        .build();
            }

            // Verifica se o CPF já existe no banco de dados
            Usuario userCpf = (Usuario) repository.findByCpf(novoUsuario.getCpf());
            if (userCpf != null) {
                return Response.status(Response.Status.BAD_REQUEST)
                        .entity("O CPF já está em uso.")
                        .build();
            }

            // Se o login e o CPF são únicos, persiste o novo usuário no repositório
            repository.persist(novoUsuario);

            // Retorna uma resposta HTTP de sucesso
            return Response.ok(UsuarioResponseDTO.valueOf(novoUsuario)).build();

        } catch (Exception e) {
            // Em caso de erro, retorna uma resposta HTTP de erro
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Erro ao inserir o livro: " + e.getMessage())
                    .build();
        }
    }

    @Override
    @Transactional
    public Response update(UsuarioDTO dto, Long id) {
        try {
            // Cria um novo objeto Usuario com base nos dados do DTO
            Usuario novoUsuario = new Usuario();
            novoUsuario.setNome(dto.nome());
            novoUsuario.setCpf(dto.cpf());
            novoUsuario.setLogin(dto.login());
            novoUsuario.setSenha(dto.senha());

            //

            // Persiste o novo livro no repositório
            repository.persist(novoUsuario);

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
            // Cria um novo objeto Usuario com base nos dados do DTO
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
    public UsuarioResponseDTO findById(Long id) {
        return UsuarioResponseDTO.valueOf(repository.findById(id));
    }

    @Override
    public List<UsuarioResponseDTO> findByNome(String nome) {
        return repository.findByNome(nome).stream()
                .map(e -> UsuarioResponseDTO.valueOf(e)).toList();
    }

    @Override
    public List<UsuarioResponseDTO> findByAll() {
        return repository.listAll().stream()
                .map(e -> UsuarioResponseDTO.valueOf(e)).toList();
    }

}