package com.example.clinisched.models.medicalConsultationModel;

import com.example.clinisched.enums.MedicalConsultationStatus;
import com.example.clinisched.models.doctorModel.DoctorModel;
import com.example.clinisched.models.patientModel.PatientModel;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "medical_consultation")
public class MedicalConsultationModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime date_consultation;

    @Enumerated(EnumType.STRING)
    private MedicalConsultationStatus status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "doctor_id")
    private DoctorModel doctor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_id")
    private PatientModel patient;
}
