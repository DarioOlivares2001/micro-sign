package com.rabbitmq.micro_sign.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rabbitmq.micro_sign.model.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
    // Métodos personalizados si los necesitas
}