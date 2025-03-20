package com.example.clinisched.models.doctorModel;

import com.example.clinisched.dto.doctorDTO.DoctorRequestDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "doctor")
public class DoctorModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String specialty;

    @Column(unique = true, nullable = false)
    private String crm;

    public DoctorModel(DoctorRequestDTO doctorRequestDTO) {
        this.id = doctorRequestDTO.getId();
        this.name = doctorRequestDTO.getName();
        this.specialty = doctorRequestDTO.getSpecialty();
        this.crm = doctorRequestDTO.getCrm();
    }
}
