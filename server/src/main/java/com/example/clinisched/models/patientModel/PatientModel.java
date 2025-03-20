    package com.example.clinisched.models.patientModel;

    import com.example.clinisched.dto.patientDTO.PatientRequestDTO;
    import jakarta.persistence.*;
    import lombok.AllArgsConstructor;
    import lombok.Data;
    import lombok.NoArgsConstructor;

    @Data
    @Entity
    @NoArgsConstructor
    @AllArgsConstructor
    @Table(name = "patient")
    public class PatientModel {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String name;
        private String phone;
        private String email;

        public PatientModel(PatientRequestDTO patientRequestDTO) {
                this.id = patientRequestDTO.getId();
                this.name = patientRequestDTO.getName();
                this.phone = patientRequestDTO.getPhone();
                this.email = patientRequestDTO.getEmail();
        }
    }

