package br.unitins.topicos1.repository;

import java.util.List;

import br.unitins.topicos1.model.Usuario;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class UsuarioRepository implements PanacheRepository<Usuario>{
    public List<Usuario> findByNome(String nome){
        return find("UPPER(nome) LIKE UPPER(?1) ", "%"+nome+"%").list();
    }
    public List<Usuario> findByLogin(String login){
        return find("UPPER(login) LIKE UPPER(?1) ", "%"+login+"%").list();
    }
    public List<Usuario> findByCpf(String cpf){
        return find("UPPER(cpf) LIKE UPPER(?1) ", "%"+cpf+"%").list();
    }
}