package com.example.email_service;


import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class EmailConsumer {

    @RabbitListener(queues = "emailQueue")
    public void receiveEmail(String message) {
        System.out.println("Email notification received: " + message);

    }
}

