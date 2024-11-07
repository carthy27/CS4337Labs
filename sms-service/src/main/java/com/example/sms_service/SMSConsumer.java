package com.example.sms_service;


import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class SMSConsumer {

    @RabbitListener(queues = "smsQueue")
    public void receiveSms(String message) {
        System.out.println("SMS notification received: " + message);

    }
}

