package com.example.push_service;


import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class PushConsumer {

    @RabbitListener(queues = "pushQueue")
    public void receivePush(String message) {
        System.out.println("Push notification received: " + message);

    }
}
