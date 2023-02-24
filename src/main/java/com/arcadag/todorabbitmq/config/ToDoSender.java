package com.arcadag.todorabbitmq.config;

import com.arcadag.todorabbitmq.domain.ToDo;
import com.arcadag.todorabbitmq.rmq.ToDoProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.text.SimpleDateFormat;
import java.util.Date;

@EnableScheduling
@Configuration
public class ToDoSender {

    @Autowired
    private ToDoProducer producer;
    @Value("${todo.amqp.queue}")
    private String destination;
    private SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
   @Scheduled(fixedRate = 500L)
   public void sendToDos() {
            producer.sendTo(
                    destination,
                    new ToDo("Do homework. Example for behavior pattern Listener " + dateFormat.format(new Date())));

    }
}
