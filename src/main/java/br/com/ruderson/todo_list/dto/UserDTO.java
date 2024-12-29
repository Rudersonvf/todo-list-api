package br.com.ruderson.todo_list.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {
    private Long id;
    @NotBlank(message = "Field required")
    @Size(min = 3, max = 100, message = "Between 3 and 80 characters")
    private String name;
    @NotBlank(message = "Field required")
    @Size(min = 3, max = 100, message = "Between 3 and 80 characters")
    private String email;
    @NotBlank(message = "Field required")
    @Size(min = 3, max = 32, message = "Between 3 and 80 characters")
    private String password;
}
