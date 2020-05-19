package com.university.doctoronline.entity;

import com.reserver.common.starter.data.jpa.basecrud.entity.BaseEntity;
import com.university.doctoronline.entity.user.Patient;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Ticket extends BaseEntity {

    @Column
    private LocalDateTime time;

    @ManyToOne
    @JoinColumn(name = "timetable_id")
    private Timetable timetable;

    @Column
    @Enumerated(EnumType.STRING)
    private TicketStatus status;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public Timetable getTimetable() {
        return timetable;
    }

    public void setTimetable(Timetable timetable) {
        this.timetable = timetable;
    }

    public TicketStatus getStatus() {
        return status;
    }

    public void setStatus(TicketStatus status) {
        this.status = status;
    }
}
