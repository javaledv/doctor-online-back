package com.university.doctoronline.dto;

public class TicketInfoDto extends TicketDto {

    private String doctorName;

    private String cabinet;

    public TicketInfoDto() {
    }

    public TicketInfoDto(TicketDto ticketDto) {
        this.id = ticketDto.getId();
        this.time = ticketDto.getTime();
        this.timetableId = ticketDto.getTimetableId();
        this.ticketStatus = ticketDto.getTicketStatus();
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getCabinet() {
        return cabinet;
    }

    public void setCabinet(String cabinet) {
        this.cabinet = cabinet;
    }
}
