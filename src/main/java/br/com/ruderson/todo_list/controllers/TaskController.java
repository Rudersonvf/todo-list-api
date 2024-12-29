package br.com.ruderson.todo_list.controllers;

import br.com.ruderson.todo_list.projections.TaskProjection;
import br.com.ruderson.todo_list.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping
    public ResponseEntity<List<TaskProjection>> getAllByUser() {
        return ResponseEntity.ok(taskService.findAllProjectedBy());
    }
}
