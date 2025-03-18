package com.example.clinisched.enums;

public enum MedicalConsultationStatus {
    PENDING_PAYMENT(0, "CANCELED"),
    PROCESSING(1, "SCHEDULED"),
    SHIPPED(2, "FINISHED");

    private final int code;
    private final String description;

    MedicalConsultationStatus(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public int getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public static MedicalConsultationStatus valueOf(int code) {
        for (MedicalConsultationStatus status : MedicalConsultationStatus.values()) {
            if (status.getCode() == code) {
                return status;
            }
        }
        throw new IllegalArgumentException("Invalid OrderStatus code: " + code);
    }
}
