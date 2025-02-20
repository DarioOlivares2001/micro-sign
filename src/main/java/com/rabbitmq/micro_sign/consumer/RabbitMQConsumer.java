package com.rabbitmq.micro_sign.consumer;


import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.rabbitmq.micro_sign.dto.AlertDTO;
import com.rabbitmq.micro_sign.dto.VitalSignDTO;
import com.rabbitmq.micro_sign.service.VitalSignService;

@Service
public class RabbitMQConsumer {
    private static final Logger log = LoggerFactory.getLogger(RabbitMQConsumer.class);
    private static final String ALERT_SERVICE_URL = "http://13.216.163.90:8080/alertas/enviar";
    private static final double VITAL_SIGN_THRESHOLD = 140.0;

    @Autowired
    private RestTemplate restTemplate;
    
    @Autowired
    private VitalSignService vitalSignService;

    @RabbitListener(queues = "${rabbitmq.queue.name}")
    public void consumeMessage(VitalSignDTO vitalSign) {
        log.info("Señal vital recibida -> {}", vitalSign);
        
        // Guardar la señal vital independientemente de su valor
        vitalSignService.saveVitalSign(vitalSign);

        // Verificar si el valor supera el umbral
        if (vitalSign.getValue() > VITAL_SIGN_THRESHOLD) {
            sendAlert(vitalSign);
            log.warn(" Valor crítico detectado: {} - Generando alerta", vitalSign.getValue());
        } else {
            log.info(" Valor normal: {}", vitalSign.getValue());
        }
    }

    private void sendAlert(VitalSignDTO vitalSign) {
        AlertDTO alerta = new AlertDTO(
            vitalSign.getPatientId(),
            "Valor crítico de " + vitalSign.getType(),
            "El valor " + vitalSign.getValue() + " supera el umbral de " + VITAL_SIGN_THRESHOLD,
            LocalDateTime.now()
        );

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<AlertDTO> request = new HttpEntity<>(alerta, headers);

        try {
            ResponseEntity<String> response = restTemplate.postForEntity(ALERT_SERVICE_URL, request, String.class);
            log.info("Alerta enviada con éxito: {}", response.getBody());
        } catch (Exception e) {
            log.error("Error al enviar alerta: ", e);
        }
    }
}