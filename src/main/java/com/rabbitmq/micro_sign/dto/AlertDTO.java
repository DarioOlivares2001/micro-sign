package com.rabbitmq.micro_sign.dto;

import java.time.LocalDateTime;

public class AlertDTO {
    private Long patientId;
    private String alertType;
    private String status;
    private LocalDateTime timestamp;

    public AlertDTO() {}

    public AlertDTO(Long patientId, String alertType, String status, LocalDateTime timestamp) {
        this.patientId = patientId;
        this.alertType = alertType;
        this.status = status;
        this.timestamp = timestamp;
    }

    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    public String getAlertType() {
        return alertType;
    }

    public void setAlertType(String alertType) {
        this.alertType = alertType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
