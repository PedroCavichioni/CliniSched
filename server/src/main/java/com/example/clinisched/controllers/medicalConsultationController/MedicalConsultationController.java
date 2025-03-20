package com.example.clinisched.controllers.medicalConsultationController;

import com.example.clinisched.dto.medicalConsultationDTO.MedicalConsultationRequestDTO;
import com.example.clinisched.dto.medicalConsultationDTO.MedicalConsultationResponseDTO;
import com.example.clinisched.models.medicalConsultationModel.MedicalConsultationModel;
import com.example.clinisched.services.medicalConsultationService.MedicalConsultationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/medical-consultation")
public class MedicalConsultationController {
    private final MedicalConsultationService medicalConsultationService;

    public MedicalConsultationController(MedicalConsultationService medicalConsultationService) {
        this.medicalConsultationService = medicalConsultationService;
    }

    @GetMapping("/all")
    public List<MedicalConsultationModel> getAllMedicalConsultation(){
        return medicalConsultationService.showAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<MedicalConsultationResponseDTO> getMedicalConsultationById(@PathVariable Long id){
        return ResponseEntity.ok(medicalConsultationService.getById(id));
    }

    @GetMapping("/medical-consultation-today")
    public List<MedicalConsultationModel> getMedicalConsultationToday(){
        return medicalConsultationService.getConsultationsToday();
    }

    @GetMapping("/send-email")
    public String setEmailToPatient(){
        medicalConsultationService.sendEmail();
        return "E-mails de lembrete enviados com sucesso!";
    }

    @PostMapping
    public ResponseEntity<MedicalConsultationModel> postMedicalConsultation(@RequestBody MedicalConsultationRequestDTO medicalConsultationRequestDTO){
        return ResponseEntity.ok(medicalConsultationService.post(medicalConsultationRequestDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<MedicalConsultationModel> updateMedicalConsultation(@PathVariable Long id, @RequestBody MedicalConsultationRequestDTO medicalConsultationRequestDTO){
        return ResponseEntity.ok(medicalConsultationService.update(id, medicalConsultationRequestDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteMedicalConsultation(@PathVariable Long id){
        medicalConsultationService.delete(id);
        return ResponseEntity.ok("Medical Consultation deleted with success!");
    }
}
