package com.arcadag.todorabbitmq.config;

import com.arcadag.todorabbitmq.domain.ToDo;
import com.arcadag.todorabbitmq.rmq.ToDoProducer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ToDoSender {
   @Bean
    public CommandLineRunner sendToDos(@Value("${todo.amqp.queue}") String destination, ToDoProducer producer) {
        return args -> {
            producer.sendTo(destination, new ToDo("Do homework. Example for behavior pattern Listener"));
        };
    }
}
