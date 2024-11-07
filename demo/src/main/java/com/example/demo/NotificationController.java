package com.example.demo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class NotificationController {
    private final NotificationProducer producer;

    public NotificationController(NotificationProducer producer) {
        this.producer = producer;
    }

    @PostMapping("/sendNotification")
    public ResponseEntity<String> sendNotification(@RequestBody NotificationMessage message, @RequestParam String exchangeType) {
        producer.sendNotification(message, exchangeType);
        return ResponseEntity.ok("Notification sent successfully");
    }
}

