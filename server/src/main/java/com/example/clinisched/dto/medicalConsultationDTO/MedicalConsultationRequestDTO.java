package com.example.clinisched.dto.medicalConsultationDTO;

import com.example.clinisched.dto.doctorDTO.DoctorRequestDTO;
import com.example.clinisched.dto.patientDTO.PatientRequestDTO;
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
public class MedicalConsultationRequestDTO {

    private Long id;
    private LocalDateTime date_consultation;
    private MedicalConsultationStatus status;
    private DoctorRequestDTO doctorRequestDTO;
    private PatientRequestDTO patientRequestDTO;

}
