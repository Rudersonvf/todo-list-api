package br.com.ruderson.todo_list.projections;

import br.com.ruderson.todo_list.enums.Priority;

public interface TaskProjection {
    Long getId();
    String getDescription();
    Priority getPriority();
    Boolean getIsComplete();
}
