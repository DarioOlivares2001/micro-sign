package com.rabbitmq.micro_sign.model;



import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "SENALES_VITALES")
public class VitalSign {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SIGNAL_ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "PACIENTE_ID", nullable = false)
    private Patient patient;

    @Column(name = "TIPO", nullable = false)
    private String type; // Ej.: "Ritmo Cardíaco", "Presión Arterial"

    @Column(name = "VALOR", nullable = false)
    private Double value;

    @Column(name = "FECHA_HORA", nullable = false)
    private LocalDateTime timestamp;

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
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
}
