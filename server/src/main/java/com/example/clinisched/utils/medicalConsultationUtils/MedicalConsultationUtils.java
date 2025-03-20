package com.example.clinisched.utils.medicalConsultationUtils;

import com.example.clinisched.enums.MedicalConsultationStatus;

public class MedicalConsultationUtils {
    public static String convertStatusFromNumber(int code) {
        return MedicalConsultationStatus.valueOf(code).getDescription();
    }
}
