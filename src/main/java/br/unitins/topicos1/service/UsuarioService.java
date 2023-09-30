package br.unitins.topicos1.service;

import java.util.List;

import br.unitins.topicos1.dto.UsuarioDTO;
import br.unitins.topicos1.dto.UsuarioResponseDTO;
import jakarta.ws.rs.core.Response;

public interface UsuarioService {
    public Response insert(UsuarioDTO dto);

    public Response update(UsuarioDTO dto, Long id);

    public Response delete(Long id);

    public UsuarioResponseDTO findById(Long id);

    public List<UsuarioResponseDTO> findByNome(String nome);

    public List<UsuarioResponseDTO> findByAll(); 
    
}