package br.com.ruderson.todo_list.repositories;

import br.com.ruderson.todo_list.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByAuthority(String authority);
}
