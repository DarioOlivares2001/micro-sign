package com.rabbitmq.micro_sign.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rabbitmq.micro_sign.dto.VitalSignDTO;
import com.rabbitmq.micro_sign.publisher.RabbitMQProducer;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/sign")
@CrossOrigin(origins = "http://localhost:4200")  // URL de tu aplicación Angular
public class SingController {
    
    
    private RabbitMQProducer rabbitMQProducer;

    public SingController(RabbitMQProducer rabbitMQProducer) {
        this.rabbitMQProducer = rabbitMQProducer;
    }

    @GetMapping("message")
    public String getMethodName(@RequestParam String message) {
        return new String();
    }
    
    @PostMapping("/publish")
    public ResponseEntity<String> sendVitalSign(@RequestBody VitalSignDTO vitalSign) {
        rabbitMQProducer.sendVitalSign(vitalSign);
        return ResponseEntity.ok("Señal vital enviada correctamente");
    }
}
