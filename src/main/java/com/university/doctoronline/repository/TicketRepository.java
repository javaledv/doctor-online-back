package com.university.doctoronline.repository;

import com.reserver.common.starter.data.jpa.basecrud.repository.BaseCrudRepository;
import com.university.doctoronline.entity.Ticket;
import com.university.doctoronline.entity.TicketStatus;
import com.university.doctoronline.entity.Timetable;
import com.university.doctoronline.entity.user.Patient;

import java.time.LocalDateTime;
import java.util.List;

public interface TicketRepository extends BaseCrudRepository<Ticket> {

    List<Ticket> findAllByTimetableAndPatientAndStatus(Timetable timetable, Patient patient, TicketStatus status);

    List<Ticket> findByTimeIsBeforeAndStatusIn(LocalDateTime time, List<TicketStatus> statuses);
}
