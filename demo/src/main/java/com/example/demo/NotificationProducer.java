package com.example.demo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class NotificationProducer {
    private final RabbitTemplate rabbitTemplate;
    private final ObjectMapper objectMapper;

    public NotificationProducer(RabbitTemplate rabbitTemplate, ObjectMapper objectMapper) {
        this.rabbitTemplate = rabbitTemplate;
        this.objectMapper = objectMapper;
    }

    public void sendNotification(NotificationMessage message, String exchangeType) {
        String exchange = exchangeType.equalsIgnoreCase("fanout") ? "fanoutExchange" : "topicExchange";
        try {
            String jsonMessage = objectMapper.writeValueAsString(message);
            String routingKey = exchangeType.equalsIgnoreCase("topic") ? message.getRoutingKey() : "";
            System.out.println("made it here");
            rabbitTemplate.convertAndSend(exchange, routingKey, jsonMessage);
        } catch (JsonProcessingException e) {
            e.printStackTrace();

        }
    }
}

