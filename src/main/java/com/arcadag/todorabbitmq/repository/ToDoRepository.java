package com.arcadag.todorabbitmq.repository;
import com.arcadag.todorabbitmq.domain.ToDo;
import org.springframework.data.repository.CrudRepository;

public interface ToDoRepository extends CrudRepository<ToDo, String> {
}
