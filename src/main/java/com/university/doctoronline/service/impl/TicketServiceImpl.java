package com.university.doctoronline.service.impl;

import com.reserver.common.starter.data.jpa.basecrud.service.impl.AbstractBaseCrudService;
import com.university.doctoronline.entity.TicketStatus;
import com.university.doctoronline.entity.Ticket;
import com.university.doctoronline.entity.Timetable;
import com.university.doctoronline.entity.user.Patient;
import com.university.doctoronline.properties.TimetableProperties;
import com.university.doctoronline.repository.TicketRepository;
import com.university.doctoronline.search.IdSearchCriteria;
import com.university.doctoronline.service.TicketService;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TicketServiceImpl extends AbstractBaseCrudService<Ticket, IdSearchCriteria> implements TicketService {

    private final TicketRepository ticketRepository;
    private final TimetableProperties timetableProperties;

    public TicketServiceImpl(TicketRepository ticketRepository, TimetableProperties timetableProperties) {
        super(ticketRepository);
        this.ticketRepository = ticketRepository;
        this.timetableProperties = timetableProperties;
    }

    @Override
    public List<Ticket> generate(Timetable timetable) {
        var appointmentTime = timetable.getStartAppointmentTime();
        final var result = new ArrayList<Ticket>();

        while (!appointmentTime.equals(timetable.getFinishAppointmentTime())) {
            final var ticket = new Ticket();
            ticket.setStatus(TicketStatus.OPENED);
            ticket.setTime(appointmentTime);
            ticket.setTimetable(timetable);

            result.add(ticket);

            appointmentTime = appointmentTime.plusMinutes(timetableProperties.getTicketAppointmentInterval());
        }

        return ticketRepository.saveAll(result);
    }

    @Override
    public List<Ticket> findAllBy(Timetable timetable, Patient patient, TicketStatus status) {
        return ticketRepository.findAllByTimetableAndPatientAndStatus(timetable, patient, status);
    }

    @Override
    public Specification<Ticket> createSpecification(IdSearchCriteria searchCriteria) {
        return null;
    }


}
