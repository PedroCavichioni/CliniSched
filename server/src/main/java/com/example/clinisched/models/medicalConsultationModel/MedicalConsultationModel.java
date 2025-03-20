package com.example.clinisched.models.medicalConsultationModel;

import com.example.clinisched.dto.medicalConsultationDTO.MedicalConsultationRequestDTO;
import com.example.clinisched.enums.MedicalConsultationStatus;
import com.example.clinisched.models.doctorModel.DoctorModel;
import com.example.clinisched.models.patientModel.PatientModel;
import com.example.clinisched.utils.attributeConverterUtils.MedicalConsultationStatusConverter;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "medical_consultation")
public class MedicalConsultationModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime date_consultation;

    @Enumerated(EnumType.STRING)
    @Convert(converter = MedicalConsultationStatusConverter.class)
    private MedicalConsultationStatus status;

    @JsonManagedReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "doctor_id")
    private DoctorModel doctor;

    @JsonManagedReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_id")
    private PatientModel patient;

    public MedicalConsultationModel (MedicalConsultationRequestDTO medicalConsultationRequestDTO){
                this.id = medicalConsultationRequestDTO.getId();
                this.date_consultation =  medicalConsultationRequestDTO.getDate_consultation();
                this.status = medicalConsultationRequestDTO.getStatus();
                this.doctor = new DoctorModel(medicalConsultationRequestDTO.getDoctorRequestDTO());
                this.patient = new PatientModel(medicalConsultationRequestDTO.getPatientRequestDTO());
    }
}
