package com.arcadag.todorabbitmq.rmq;

import com.arcadag.todorabbitmq.domain.ToDo;
import com.arcadag.todorabbitmq.repository.ToDoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ToDoConsumer {

    private ToDoRepository repository;

    public ToDoConsumer(ToDoRepository repository) {
        this.repository = repository;
    }

    @RabbitListener(queues = "${todo.amqp.queue}")
    public void processToDo(ToDo toDo) {
        log.info("Consumer> " + toDo);
        log.info("ToDo created> " + this.repository.save(toDo));
    }
}
