package com.example.clinisched.controllers.DoctorController;

import com.example.clinisched.dto.doctorDTO.DoctorRequestDTO;
import com.example.clinisched.dto.doctorDTO.DoctorResponseDTO;
import com.example.clinisched.models.doctorModel.DoctorModel;
import com.example.clinisched.services.doctorService.DoctorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/doctor")
public class DoctorController {
    private final DoctorService doctorService;

    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @GetMapping("/all")
    public List<DoctorModel> showAllDoctor(){
        return doctorService.showAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DoctorResponseDTO> getDoctorById(@PathVariable Long id){
        return ResponseEntity.ok(doctorService.getById(id));
    }

    @PostMapping
    public ResponseEntity<DoctorModel> postDoctor(@RequestBody DoctorRequestDTO doctorRequestDTO){
        return ResponseEntity.ok(doctorService.post(doctorRequestDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DoctorModel> updateDoctor(@PathVariable Long id, @RequestBody DoctorRequestDTO doctorRequestDTO){
        return ResponseEntity.ok(doctorService.update(id, doctorRequestDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDoctor(@PathVariable Long id){
        doctorService.delete(id);
        return ResponseEntity.ok("Doctor deleted with success!");
    }
}
