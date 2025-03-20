package com.example.clinisched.dto.doctorDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DoctorRequestDTO {

    private Long id;
    private String name;
    private String specialty;
    private String crm;
}
