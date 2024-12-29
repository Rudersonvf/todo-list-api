package br.com.ruderson.todo_list.dto;

public record UserResponseDTO(
        Long id,
        String name,
        String email
) {
}
