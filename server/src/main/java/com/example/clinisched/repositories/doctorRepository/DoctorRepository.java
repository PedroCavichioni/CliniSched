package com.example.clinisched.repositories.doctorRepository;

import com.example.clinisched.models.doctorModel.DoctorModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepository extends JpaRepository<DoctorModel, Long> {
}
