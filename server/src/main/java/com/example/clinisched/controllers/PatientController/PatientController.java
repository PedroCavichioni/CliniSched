package com.example.clinisched.controllers.PatientController;

import com.example.clinisched.models.patientModel.PatientModel;
import com.example.clinisched.services.patientService.PatientService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/patient")
public class PatientController {
    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping("/all")
    public List<PatientModel> showAllPatient(){
        return patientService.showAll();
    }

    @GetMapping("/{id}")
    public PatientModel getPatientById(@PathVariable Long id){
        return patientService.getById(id);
    }

    @PostMapping
    public PatientModel postPatient(@RequestBody PatientModel patientModel){
        return patientService.post(patientModel);
    }

    @DeleteMapping("/{id}")
    public void deletePatient(@PathVariable Long id){
        patientService.delete(id);
    }
}
