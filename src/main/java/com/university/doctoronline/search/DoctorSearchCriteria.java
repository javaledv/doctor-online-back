package com.university.doctoronline.search;

public class DoctorSearchCriteria extends IdSearchCriteria {

    private Long specializationId;

    public Long getSpecializationId() {
        return specializationId;
    }

    public void setSpecializationId(Long specializationId) {
        this.specializationId = specializationId;
    }
}
