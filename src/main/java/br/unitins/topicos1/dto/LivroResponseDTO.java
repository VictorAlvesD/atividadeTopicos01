package br.unitins.topicos1.dto;

import br.unitins.topicos1.model.Livro;

public record LivroResponseDTO(
    Long id,
    String nome,
    String autor,
    String editora,
    String genero) {
        public static LivroResponseDTO valueOf(Livro livro){
            return new LivroResponseDTO(
                livro.getId(), 
                livro.getNome(),
                livro.getAutor(),
                livro.getEditora(),
                livro.getGenero()
            );
        }
}