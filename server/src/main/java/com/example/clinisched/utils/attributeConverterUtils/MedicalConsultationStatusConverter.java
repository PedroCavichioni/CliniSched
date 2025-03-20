package com.example.clinisched.utils.attributeConverterUtils;

import com.example.clinisched.enums.MedicalConsultationStatus;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class MedicalConsultationStatusConverter implements AttributeConverter<MedicalConsultationStatus, String> {

    @Override
    public String convertToDatabaseColumn(MedicalConsultationStatus status) {
        return (status != null) ? status.getDescription() : null;
    }

    @Override
    public MedicalConsultationStatus convertToEntityAttribute(String description) {
        for (MedicalConsultationStatus status : MedicalConsultationStatus.values()) {
            if (status.getDescription().equals(description)) {
                return status;
            }
        }
        throw new IllegalArgumentException("Invalid MedicalConsultationStatus description: " + description);
    }
}
