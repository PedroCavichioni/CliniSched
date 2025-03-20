package com.example.clinisched.utils.medicalConsultationUtils;

import com.example.clinisched.enums.MedicalConsultationStatus;

public class MedicalConsultationUtils {
    public static String convertStatusFromNumber(int code) {
        for (MedicalConsultationStatus status : MedicalConsultationStatus.values()) {
            if (status.getCode() == code) {
                return status.getDescription();
            }
        }
        throw new IllegalArgumentException("Invalid MedicalConsultationStatus code: " + code);
    }
}
