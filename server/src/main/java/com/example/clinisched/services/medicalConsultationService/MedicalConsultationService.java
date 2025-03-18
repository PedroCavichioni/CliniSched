package com.example.clinisched.services.medicalConsultationService;

import com.example.clinisched.exception.NotFoundException;
import com.example.clinisched.models.medicalConsultationModel.MedicalConsultationModel;
import com.example.clinisched.repositories.medicalConsultationRepository.MedicalConsultationRepository;
import com.example.clinisched.services.emailService.EmailService;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

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

    public MedicalConsultationModel getById(Long id){
        return medicalConsultationRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(id));
    }

    public MedicalConsultationModel post(MedicalConsultationModel medicalConsultationModel){
        return medicalConsultationRepository.save(medicalConsultationModel);
    }

    @Scheduled(cron = "0 0 8 * * ?")
    public void sendDailyConsultationReminders() {
        sendEmail();
    }

    public void sendEmail(){
        LocalDateTime todayStart = LocalDateTime.now().with(LocalTime.MIN);
        LocalDateTime todayEnd = LocalDateTime.now().with(LocalTime.MAX);

        List<MedicalConsultationModel> consultations = medicalConsultationRepository.findByDateConsultationBetween(todayStart, todayEnd);

        for(MedicalConsultationModel consultationModel : consultations){
            String email = consultationModel.getPatient().getEmail();
            String subject = "Lembrete de Consulta Médica";
            String body = "Olá, " + consultationModel.getPatient().getName() + ",<br><br>" +
                    "Você tem uma consulta médica hoje às <b>" + consultationModel.getDate_consultation().toLocalTime() + "</b>.<br><br>" +
                    "Atenciosamente, <br>CliniSched.";
            try{
                emailService.sendEmail(email, subject, body);
            }catch (MessagingException err){
                System.out.println("Erro ao enviar e-mail para " + email + ": " + err.getMessage());
            }
        }
    }

    public List<MedicalConsultationModel> getConsultationsToday(){
        LocalDateTime todayStart = LocalDateTime.now().with(LocalTime.MIN);
        LocalDateTime todayEnd = LocalDateTime.now().with(LocalTime.MAX);

        return medicalConsultationRepository.findByDateConsultationBetween(todayStart, todayEnd);
    }

    public void delete(Long id){
        medicalConsultationRepository.deleteById(id);
    }
}
