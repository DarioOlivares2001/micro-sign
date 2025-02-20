package com.rabbitmq.micro_sign.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rabbitmq.micro_sign.dto.VitalSignDTO;
import com.rabbitmq.micro_sign.model.Patient;
import com.rabbitmq.micro_sign.model.VitalSign;
import com.rabbitmq.micro_sign.repository.PatientRepository;
import com.rabbitmq.micro_sign.repository.VitalSignRepository;

@Service
public class VitalSignService {

    @Autowired
    private VitalSignRepository vitalSignRepository;
    
    @Autowired
    private PatientRepository patientRepository;

    public void saveVitalSign(VitalSignDTO vitalSignDTO) {
        VitalSign vitalSign = new VitalSign();
        Patient patient = patientRepository.findById(vitalSignDTO.getPatientId())
            .orElseThrow(() -> new RuntimeException("Paciente no encontrado"));
        
        vitalSign.setPatient(patient);
        vitalSign.setType(vitalSignDTO.getType());
        vitalSign.setValue(vitalSignDTO.getValue());
        vitalSign.setTimestamp(vitalSignDTO.getTimestamp());
        
        vitalSignRepository.save(vitalSign);
    }
}