package com.university.doctoronline.search;

public class TicketSearchCriteria extends IdSearchCriteria {
    private Long patientId;

    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }
}
