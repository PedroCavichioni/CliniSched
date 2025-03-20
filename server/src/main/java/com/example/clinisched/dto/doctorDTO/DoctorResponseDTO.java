package com.example.clinisched.dto.doctorDTO;

import com.example.clinisched.models.doctorModel.DoctorModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DoctorResponseDTO {

    private Long id;
    private String name;
    private String specialty;
    private String crm;

    public DoctorResponseDTO(DoctorModel doctorModel){
        this(
                doctorModel.getId(),
                doctorModel.getName(),
                doctorModel.getSpecialty(),
                doctorModel.getCrm());
    }
}
