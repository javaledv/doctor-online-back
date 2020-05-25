package com.university.doctoronline.search;

import com.university.doctoronline.entity.TicketStatus;

public class TicketSearchCriteria extends IdSearchCriteria {
    private Long patientId;

    private TicketStatus status;

    public TicketStatus getStatus() {
        return status;
    }

    public void setStatus(TicketStatus status) {
        this.status = status;
    }

    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }
}
