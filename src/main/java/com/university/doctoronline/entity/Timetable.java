package com.university.doctoronline.entity;

import com.reserver.common.starter.data.jpa.basecrud.entity.BaseEntity;
import com.university.doctoronline.entity.user.Doctor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Timetable extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;

    @Column
    private LocalDate day;

    @Column
    private LocalDateTime startAppointmentTime;

    @Column
    private LocalDateTime finishAppointmentTime;

    @OneToMany
    private List<Ticket> tickets;

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public LocalDate getDay() {
        return day;
    }

    public void setDay(LocalDate day) {
        this.day = day;
    }

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

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }
}
