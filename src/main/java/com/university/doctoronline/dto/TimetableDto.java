package com.university.doctoronline.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class TimetableDto extends BaseDto {

    private Long doctorId;

    private LocalDate date;

    private LocalDateTime startAppointmentTime;
    private LocalDateTime finishAppointmentTime;

    private List<TicketDto> tickets;

    public LocalDateTime getStartAppointmentTime() {
        return startAppointmentTime;
    }

    public void setStartAppointmentTime(LocalDateTime startAppointmentTime) {
        this.startAppointmentTime = startAppointmentTime;
    }

    public LocalDateTime getFinishAppointmentTime() {
        return finishAppointmentTime;
    }

    public void setFinishAppointmentTime(LocalDateTime finishAppointmentTime) {
        this.finishAppointmentTime = finishAppointmentTime;
    }

    public Long getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Long doctorId) {
        this.doctorId = doctorId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public List<TicketDto> getTickets() {
        return tickets;
    }

    public void setTickets(List<TicketDto> tickets) {
        this.tickets = tickets;
    }
}
