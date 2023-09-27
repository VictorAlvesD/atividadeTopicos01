package br.unitins.topicos1.service;

import java.util.List;

import br.unitins.topicos1.dto.*;
import jakarta.ws.rs.core.Response;

public interface LivroService {

    public Response insert(LivroDTO dto);

    public Response update(LivroDTO dto, Long id);

    public Response delete(Long id);

    public LivroResponseDTO findById(Long id);

    public List<LivroResponseDTO> findByNome(String nome);

    public List<LivroResponseDTO> findByAll(); 
    
}
