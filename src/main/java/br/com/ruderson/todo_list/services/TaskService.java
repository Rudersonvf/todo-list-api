package br.com.ruderson.todo_list.services;

import br.com.ruderson.todo_list.dto.TaskDTO;
import br.com.ruderson.todo_list.entities.Task;
import br.com.ruderson.todo_list.entities.User;
import br.com.ruderson.todo_list.projections.TaskProjection;
import br.com.ruderson.todo_list.repositories.TaskRepository;
import br.com.ruderson.todo_list.services.exceptions.DatabaseException;
import br.com.ruderson.todo_list.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private AuthService authService;

    @Transactional(readOnly = true)
    public List<TaskProjection> findAllProjectedBy() {
        User user = userService.authenticated();
        return taskRepository.findAllTasksProjectedBy(user.getId());
    }

    @Transactional(readOnly = true)
    public TaskDTO findById(Long id) {
        Task result = taskRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Task not found with id: " + id));

        authService.validateSelfOrAdmin(result.getUser().getId());

        TaskDTO response = new TaskDTO();
        BeanUtils.copyProperties(result, response);

        return response;
    }

    @Transactional
    public TaskDTO insertNewTask(TaskDTO dto) {
        Task entity = new Task();
        entity.setDescription(dto.getDescription());
        entity.setPriority(dto.getPriority());
        entity.setIsComplete(false);
        entity.setCreatedAt(LocalDateTime.now());

        User user = userService.authenticated();
        entity.setUser(user);

        entity = taskRepository.save(entity);

        TaskDTO response = new TaskDTO();
        BeanUtils.copyProperties(entity, response);

        return response;
    }

    @Transactional
    public TaskDTO switchTaskStatus(Long id, Boolean status) {
        try {
            Task entity = taskRepository.getReferenceById(id);

            authService.validateSelfOrAdmin(entity.getUser().getId());

            entity.setIsComplete(status);

            if (Boolean.TRUE.equals(status)) {
                entity.setCompletedAt(LocalDateTime.now());
            } else {
                entity.setCompletedAt(null);
            }

            entity = taskRepository.save(entity);

            TaskDTO response = new TaskDTO();
            BeanUtils.copyProperties(entity, response);

            return response;
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Task not found with id: " + id);
        }
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public void deleteTask(Long id) {
        try {
            Task entity = taskRepository.findById(id).orElseThrow(() ->
                    new ResourceNotFoundException("Task not found with id: " + id));

            authService.validateSelfOrAdmin(entity.getUser().getId());

            taskRepository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Referential integrity constraint violation.");
        }
    }
}
