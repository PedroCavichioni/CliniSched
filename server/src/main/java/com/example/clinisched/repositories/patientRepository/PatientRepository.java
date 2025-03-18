package com.example.clinisched.repositories.patientRepository;

import com.example.clinisched.models.patientModel.PatientModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<PatientModel, Long> {
}
