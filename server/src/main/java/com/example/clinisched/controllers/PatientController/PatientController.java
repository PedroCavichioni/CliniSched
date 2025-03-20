package com.example.clinisched.controllers.PatientController;

import com.example.clinisched.dto.patientDTO.PatientRequestDTO;
import com.example.clinisched.dto.patientDTO.PatientResponseDTO;
import com.example.clinisched.models.patientModel.PatientModel;
import com.example.clinisched.services.patientService.PatientService;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<PatientResponseDTO> getPatientById(@PathVariable Long id){
        return ResponseEntity.ok(patientService.getById(id));
    }

    @PostMapping
    public ResponseEntity<PatientModel> postPatient(@RequestBody PatientRequestDTO patientRequestDTO){
        return ResponseEntity.ok(patientService.post(patientRequestDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PatientModel> updatePatient(@PathVariable Long id, @RequestBody PatientRequestDTO patientRequestDTO){
        return ResponseEntity.ok(patientService.update(id, patientRequestDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePatient(@PathVariable Long id){
        patientService.delete(id);
        return ResponseEntity.ok("Patient deleted with success!");
    }
}
