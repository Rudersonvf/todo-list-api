package br.com.ruderson.todo_list.dto;

import br.com.ruderson.todo_list.enums.Priority;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class TaskDTO {
    private Long id;
    @NotBlank(message = "Field required.")
    @Size(min = 3, max = 120, message = "Must contain between 3 and 120 characters.")
    private String description;
    @NotBlank(message = "Field required.")
    private Priority priority;
    private Boolean isComplete;
    private LocalDateTime createdAt;
    private LocalDateTime completedAt;
}
