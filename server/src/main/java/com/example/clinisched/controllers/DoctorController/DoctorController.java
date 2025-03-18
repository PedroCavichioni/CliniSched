package com.example.clinisched.controllers.DoctorController;

import com.example.clinisched.models.doctorModel.DoctorModel;
import com.example.clinisched.services.doctorService.DoctorService;
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
    public DoctorModel getDoctorById(@PathVariable Long id){
        return doctorService.getById(id);
    }

    @PostMapping
    public DoctorModel postDoctor(@RequestBody DoctorModel doctorModel){
        return doctorService.post(doctorModel);
    }

    @DeleteMapping("/{id}")
    public void deleteDoctor(@PathVariable Long id){
        doctorService.delete(id);
    }
}
