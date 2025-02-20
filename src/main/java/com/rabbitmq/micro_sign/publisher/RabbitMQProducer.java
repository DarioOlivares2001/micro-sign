package com.rabbitmq.micro_sign.publisher;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.rabbitmq.micro_sign.dto.VitalSignDTO;

@Service
public class RabbitMQProducer {

    @Value("${rabbitmq.exchange.name}")
    private String exchange;

    @Value("${rabbitmq.routing.key}")
    private String routingkey;

   
    private static final Logger log = LoggerFactory.getLogger(RabbitMQProducer.class);

    private RabbitTemplate rabbitTemplate;


    public RabbitMQProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendVitalSign(VitalSignDTO vitalSign) {
        log.info("Enviando señal vital: {}", vitalSign);
        rabbitTemplate.convertAndSend(exchange, routingkey, vitalSign);
    }
    
}
