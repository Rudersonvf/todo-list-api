package br.com.ruderson.todo_list.controllers;

import br.com.ruderson.todo_list.dto.TaskDTO;
import br.com.ruderson.todo_list.projections.TaskProjection;
import br.com.ruderson.todo_list.services.TaskService;
import org.apache.coyote.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;


    @GetMapping
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
    public ResponseEntity<List<TaskProjection>> getAllByUser() {
        return ResponseEntity.ok(taskService.findAllProjectedBy());
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
    public ResponseEntity<TaskDTO> getTaskDetails(@PathVariable Long id){
        return ResponseEntity.ok(taskService.findById(id));
    }

    @PostMapping
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
    public ResponseEntity<TaskDTO> postNewTask(@RequestBody TaskDTO request) {
        TaskDTO response = taskService.insertNewTask(request);
        return ResponseEntity.created(URI.create("/task/" + response.getId())).body(response);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
    public ResponseEntity<TaskDTO> putTaskStatus(@PathVariable Long id, @RequestBody Boolean request) {
        return ResponseEntity.ok(taskService.switchTaskStatus(id, request));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
        return ResponseEntity.noContent().build();
    }
}
