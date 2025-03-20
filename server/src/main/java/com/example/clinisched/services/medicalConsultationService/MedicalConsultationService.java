package com.example.clinisched.services.medicalConsultationService;

import com.example.clinisched.dto.medicalConsultationDTO.MedicalConsultationRequestDTO;
import com.example.clinisched.dto.medicalConsultationDTO.MedicalConsultationResponseDTO;
import com.example.clinisched.models.medicalConsultationModel.MedicalConsultationModel;
import com.example.clinisched.repositories.medicalConsultationRepository.MedicalConsultationRepository;
import com.example.clinisched.services.emailService.EmailService;
import jakarta.mail.MessagingException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MedicalConsultationService {
    @Autowired
    private EmailService emailService;

    @Autowired
    private final MedicalConsultationRepository medicalConsultationRepository;


    public MedicalConsultationService(MedicalConsultationRepository medicalConsultationRepository) {
        this.medicalConsultationRepository = medicalConsultationRepository;
    }

    public List<MedicalConsultationModel> showAll(){
        return medicalConsultationRepository.findAll();
    }

    public MedicalConsultationResponseDTO getById(Long id){
        MedicalConsultationModel medicalConsultationModel = medicalConsultationRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Medical Consultation with ID " + id + " not found!"));
        return new MedicalConsultationResponseDTO(medicalConsultationModel);
    }

    public MedicalConsultationModel post(MedicalConsultationRequestDTO medicalConsultationRequestDTO){
        try{
            MedicalConsultationModel medicalConsultationModel = new MedicalConsultationModel(medicalConsultationRequestDTO);
            return medicalConsultationRepository.save(medicalConsultationModel);
        } catch (Exception e){
            throw new RuntimeException("Error to save medical consultation. Try again later!" + e);
        }
    }

    public MedicalConsultationModel update(Long id, MedicalConsultationRequestDTO medicalConsultationRequestDTO){
        MedicalConsultationModel existingMedicalConsultation = medicalConsultationRepository.findById(medicalConsultationRequestDTO.getId())
                .orElseThrow(() ->new EntityNotFoundException("Medical Consultation with ID " + id + " not found!"));

        existingMedicalConsultation.setDate_consultation(existingMedicalConsultation.getDate_consultation());
        existingMedicalConsultation.setStatus(existingMedicalConsultation.getStatus());
        existingMedicalConsultation.setDoctor(existingMedicalConsultation.getDoctor());
        existingMedicalConsultation.setPatient(existingMedicalConsultation.getPatient());

        return medicalConsultationRepository.save(existingMedicalConsultation);
    }

    @Scheduled(cron = "0 0 8 * * ?")
    public void sendDailyConsultationReminders() {
        sendEmail();
    }

    public void sendEmail(){
        LocalDateTime todayStart = LocalDateTime.now().with(LocalTime.MIN);
        LocalDateTime todayEnd = LocalDateTime.now().with(LocalTime.MAX);

        List<MedicalConsultationModel> consultations = medicalConsultationRepository.findByDateConsultationBetween(todayStart, todayEnd);

        List<MedicalConsultationResponseDTO> consultationResponseDTOS = consultations.stream()
                .map(MedicalConsultationResponseDTO::new)
                .collect(Collectors.toList());

        for(MedicalConsultationResponseDTO consultationResponseDTO : consultationResponseDTOS){
            String email = consultationResponseDTO.getPatientRequestDTO().getEmail();
            String subject = "Lembrete de Consulta Médica";
            String body = "Olá, " + consultationResponseDTO.getPatientRequestDTO().getName() + ",<br><br>" +
                    "Você tem uma consulta médica hoje às <b>" + consultationResponseDTO.getDate_consultation().toLocalTime() + "</b> com "
                    + consultationResponseDTO.getDoctorRequestDTO().getName()
                    + " - " + consultationResponseDTO.getDoctorRequestDTO().getSpecialty() + "<br><br>" +
                    "Atenciosamente, <br>CliniSched.";

            System.out.println("Enviando e-mail para: " + email);
            try{
                emailService.sendEmail(email, subject, body);
            }catch (MessagingException err){
                System.out.println("Error to send email " + email + ": " + err.getMessage());
            }
        }
    }

    public List<MedicalConsultationModel> getConsultationsToday(){
        LocalDateTime todayStart = LocalDateTime.now().with(LocalTime.MIN);
        LocalDateTime todayEnd = LocalDateTime.now().with(LocalTime.MAX);

        return medicalConsultationRepository.findByDateConsultationBetween(todayStart, todayEnd);
    }

    public void delete(Long id){
        if(!medicalConsultationRepository.existsById(id)){
            throw new EntityNotFoundException("Medical Consultation with ID " + id + " not found!");
        }
        medicalConsultationRepository.deleteById(id);
    }
}
