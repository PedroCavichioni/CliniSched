package com.example.clinisched.repositories.medicalConsultationRepository;

import com.example.clinisched.models.medicalConsultationModel.MedicalConsultationModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface MedicalConsultationRepository extends JpaRepository<MedicalConsultationModel, Long> {

    @Query("SELECT m FROM MedicalConsultationModel m WHERE m.date_consultation BETWEEN :startDate AND :endDate")
    List<MedicalConsultationModel> findByDateConsultationBetween(
            @Param("startDate") LocalDateTime startDate,
            @Param("endDate") LocalDateTime endDate
    );
}
