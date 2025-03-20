package com.example.clinisched.dto.medicalConsultationDTO;

import com.example.clinisched.dto.doctorDTO.DoctorResponseDTO;
import com.example.clinisched.dto.patientDTO.PatientResponseDTO;
import com.example.clinisched.enums.MedicalConsultationStatus;
import com.example.clinisched.models.medicalConsultationModel.MedicalConsultationModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MedicalConsultationResponseDTO {

    private Long id;
    private LocalDateTime date_consultation;
    private MedicalConsultationStatus status;
    private DoctorResponseDTO doctorRequestDTO;
    private PatientResponseDTO patientRequestDTO;

    public MedicalConsultationResponseDTO(MedicalConsultationModel medicalConsultationModel){
        this(
                medicalConsultationModel.getId(),
                medicalConsultationModel.getDate_consultation(),
                medicalConsultationModel.getStatus(),
                new DoctorResponseDTO(medicalConsultationModel.getDoctor()),
                new PatientResponseDTO(medicalConsultationModel.getPatient()));
    }
}
