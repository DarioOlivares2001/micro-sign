package com.rabbitmq.micro_sign.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "PACIENTES")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PACIENTE_ID")
    private Long id;

    @Column(name = "NOMBRE", nullable = false)
    private String name;

    @Column(name = "EDAD", nullable = false)
    private Integer age;

    @Column(name = "SALA", nullable = false)
    private String room;

    @Column(name = "CAMA", nullable = false)
    private String bed;

    @Column(name = "FECHA_REGISTRO", nullable = false)
    private LocalDate registrationDate;

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getBed() {
        return bed;
    }

    public void setBed(String bed) {
        this.bed = bed;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }
}
