package com.university.doctoronline.service;

import com.reserver.common.starter.data.jpa.basecrud.service.BaseCrudService;
import com.university.doctoronline.entity.Ticket;
import com.university.doctoronline.entity.TicketStatus;
import com.university.doctoronline.entity.Timetable;
import com.university.doctoronline.entity.user.Patient;
import com.university.doctoronline.search.TicketSearchCriteria;

import java.time.LocalDateTime;
import java.util.List;

public interface TicketService extends BaseCrudService<Ticket, TicketSearchCriteria> {

    List<Ticket> generate(Timetable timetable);

    List<Ticket> findAllBy(Timetable timetable, Patient patient, TicketStatus status);

    List<Ticket> findExpired(LocalDateTime localDateTime, List<TicketStatus> statuses);


}
