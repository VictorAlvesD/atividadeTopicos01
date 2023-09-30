package br.unitins.topicos1.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;

public record  UsuarioDTO(
    String nome,
    @Pattern(regexp = "^(?!000\\.000\\.000-00|111\\.111\\.111-11|222\\.222\\.222-22|333\\.333\\.333-33|444\\.444\\.444-44|555\\.555\\.555-55|666\\.666\\.666-66|777\\.777\\.777-77|888\\.888\\.888-88|999\\.999\\.999-99)[0-9]{3}\\.[0-9]{3}\\.[0-9]{3}-[0-9]{2}$", message = "CPF inválido.")
    String cpf,
    @Email(message = "O endereço de e-mail não é válido.")
    String login,
    String senha
    )
{

}
