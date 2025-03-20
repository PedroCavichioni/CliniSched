package com.example.clinisched.services.patientService;

import com.example.clinisched.dto.patientDTO.PatientRequestDTO;
import com.example.clinisched.dto.patientDTO.PatientResponseDTO;
import com.example.clinisched.models.patientModel.PatientModel;
import com.example.clinisched.repositories.patientRepository.PatientRepository;
import jakarta.persistence.EntityNotFoundException;
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

    public PatientResponseDTO getById(Long id){
        PatientModel patientModel = patientRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Patient with ID " + id + " not found!"));
        return new PatientResponseDTO(patientModel);
    }

    public PatientModel post(PatientRequestDTO patientRequestDTO){
        try{
            PatientModel patientModel = new PatientModel(patientRequestDTO);
            return patientRepository.save(patientModel);
        } catch (Exception e) {
            throw new RuntimeException("Error to save patient. Try again later!");
        }
    }

    public PatientModel update(Long id, PatientRequestDTO patientRequestDTO) {
        PatientModel existingPatient = patientRepository.findById(patientRequestDTO.getId())
                .orElseThrow(() -> new EntityNotFoundException("Patient with ID " + id + " not found!"));

        existingPatient.setName(patientRequestDTO.getName());
        existingPatient.setEmail(patientRequestDTO.getEmail());
        existingPatient.setPhone(patientRequestDTO.getPhone());

        return patientRepository.save(existingPatient);
    }


    public void delete(Long id){
        if(!patientRepository.existsById(id)){
            throw new EntityNotFoundException("Patient with ID " + id + " not found!");
        }
        patientRepository.deleteById(id);
    }

}
