package com.example.clinisched.services.patientService;

import com.example.clinisched.exception.NotFoundException;
import com.example.clinisched.models.patientModel.PatientModel;
import com.example.clinisched.repositories.patientRepository.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {
    private final PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public List<PatientModel> showAll(){
        return patientRepository.findAll();
    }

    public PatientModel getById(Long id){
        return patientRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(id));
    }

    public PatientModel post(PatientModel patientModel){
        return patientRepository.save(patientModel);
    }

    public void delete(Long id){
        patientRepository.deleteById(id);
    }

}
