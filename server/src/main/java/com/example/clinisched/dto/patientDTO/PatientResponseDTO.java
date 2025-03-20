package com.example.clinisched.dto.patientDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import com.example.clinisched.models.patientModel.PatientModel;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PatientResponseDTO {

    private Long id;
    private String name;
    private String phone;
    private String email;

    public PatientResponseDTO(PatientModel patientModel) {
        this(
                patientModel.getId(),
                patientModel.getName(),
                patientModel.getPhone(),
                patientModel.getEmail());
    }
}
