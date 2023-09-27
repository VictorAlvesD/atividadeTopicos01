package br.unitins.topicos1.dto;

import java.util.List;

public record LivroDTO (
     String nome,
     String autor,
     String editora,
     String isbn,
     String genero
) {}