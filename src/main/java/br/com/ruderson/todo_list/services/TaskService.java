package br.com.ruderson.todo_list.services;

import br.com.ruderson.todo_list.entities.User;
import br.com.ruderson.todo_list.projections.TaskProjection;
import br.com.ruderson.todo_list.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private UserService userService;

    @Transactional(readOnly = true)
    public List<TaskProjection> findAllProjectedBy() {
        User user = userService.authenticated();
        return taskRepository.findAllTasksProjectedBy(user.getId());
    }
}
