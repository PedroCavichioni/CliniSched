package com.example.clinisched.services.doctorService;

import com.example.clinisched.exception.NotFoundException;
import com.example.clinisched.models.doctorModel.DoctorModel;
import com.example.clinisched.repositories.doctorRepository.DoctorRepository;
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

    public DoctorModel getById(Long id){
            return doctorRepository.findById(id)
                    .orElseThrow(() -> new NotFoundException(id));
    }

    public DoctorModel post(DoctorModel doctorModel){
        return doctorRepository.save(doctorModel);
    }

    public void delete(Long id){
        doctorRepository.deleteById(id);
    }
}
