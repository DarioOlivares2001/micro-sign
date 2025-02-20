package com.rabbitmq.micro_sign.dto;

import java.time.LocalDateTime;

public class VitalSignDTO {
    private Long patientId;
    private String type;
    private Double value;
    private LocalDateTime timestamp;

    // Getters y setters
    // Constructor vacío necesario para Jackson
    public VitalSignDTO() {}

    // Constructor con parámetros
    public VitalSignDTO(Long patientId, String type, Double value, LocalDateTime timestamp) {
        this.patientId = patientId;
        this.type = type;
        this.value = value;
        this.timestamp = timestamp;
    }

    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    // Getters y setters

    
}