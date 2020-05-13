package com.university.doctoronline.dto;

public class DoctorDto extends UserDto {

    private String cabinet;
    private DoctorSpecializationDto doctorSpecializationId;

    public String getCabinet() {
        return cabinet;
    }

    public void setCabinet(String cabinet) {
        this.cabinet = cabinet;
    }

    public DoctorSpecializationDto getDoctorSpecialization() {
        return doctorSpecializationId;
    }

    public void setDoctorSpecialization(DoctorSpecializationDto doctorSpecializationId) {
        this.doctorSpecializationId = doctorSpecializationId;
    }
}
