package br.com.ruderson.todo_list.repositories;

import br.com.ruderson.todo_list.entities.Task;
import br.com.ruderson.todo_list.projections.TaskProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
    @Query("SELECT t.id AS id, " +
            "t.description AS description, " +
            "t.priority AS priority, " +
            "t.isComplete AS isComplete " +
            "FROM Task t " +
            "WHERE t.user.id = :userId")
    List<TaskProjection> findAllTasksProjectedBy(@Param("userId") Long userId);
}
