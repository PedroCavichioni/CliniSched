package com.example.clinisched.controllers.medicalConsultationController;

import com.example.clinisched.models.medicalConsultationModel.MedicalConsultationModel;
import com.example.clinisched.services.medicalConsultationService.MedicalConsultationService;
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
    public MedicalConsultationModel getMedicalConsultationById(@PathVariable Long id){
        return medicalConsultationService.getById(id);
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
    public MedicalConsultationModel postMedicalConsultation(@RequestBody MedicalConsultationModel medicalConsultationModel){
        return medicalConsultationService.post(medicalConsultationModel);
    }

    @DeleteMapping("/{id}")
    public void deleteMedicalConsultation(@PathVariable Long id){
        medicalConsultationService.delete(id);
    }
}
