package com.example.clinisched.services.doctorService;

import com.example.clinisched.dto.doctorDTO.DoctorRequestDTO;
import com.example.clinisched.dto.doctorDTO.DoctorResponseDTO;
import com.example.clinisched.models.doctorModel.DoctorModel;
import com.example.clinisched.repositories.doctorRepository.DoctorRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {
    private final DoctorRepository doctorRepository;

    public DoctorService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    public List<DoctorModel> showAll(){
        return doctorRepository.findAll();
    }

    public DoctorResponseDTO getById(Long id){
            DoctorModel doctorModel = doctorRepository.findById(id)
                    .orElseThrow(() -> new EntityNotFoundException("Doctor with ID " + id + " not found!"));
        return new DoctorResponseDTO(doctorModel);
    }

    public DoctorModel post(DoctorRequestDTO doctorRequestDTO){
        try{
            DoctorModel doctorModel = new DoctorModel(doctorRequestDTO);
            return doctorRepository.save(doctorModel);
        } catch (Exception e) {
            throw new RuntimeException("Error to save doctor. Try again later!");
        }
    }

    public DoctorModel update(Long id, DoctorRequestDTO doctorRequestDTO){
        DoctorModel doctorModel = new DoctorModel(doctorRequestDTO);
        DoctorModel existingDoctor = doctorRepository.findById(doctorRequestDTO.getId())
                .orElseThrow(()-> new EntityNotFoundException("Doctor with ID " + id + " not found!"));

        existingDoctor.setName(doctorRequestDTO.getName());
        existingDoctor.setSpecialty(doctorRequestDTO.getSpecialty());
        existingDoctor.setCrm(doctorRequestDTO.getCrm());

        return doctorRepository.save(doctorModel);
    }

    public void delete(Long id){
        if(!doctorRepository.existsById(id)){
            throw new EntityNotFoundException("Doctor with ID " + id + " not found!");
        }
        doctorRepository.deleteById(id);
    }
}
