package br.com.ruderson.todo_list.dto.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.Instant;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class CustomError {
    private Instant timestamp;
    private Integer status;
    private String error;
    private String path;
}
