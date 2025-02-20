package com.rabbitmq.micro_sign.repository;


import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rabbitmq.micro_sign.model.VitalSign;

@Repository
public interface VitalSignRepository extends JpaRepository<VitalSign, Long> {
    // Métodos personalizados si los necesitas
    List<VitalSign> findByPatientId(Long patientId);
    List<VitalSign> findByPatientIdAndType(Long patientId, String type);
    List<VitalSign> findByTimestampBetween(LocalDateTime start, LocalDateTime end);
}