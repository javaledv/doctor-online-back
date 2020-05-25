package com.university.doctoronline.service.impl;

import com.reserver.common.starter.data.jpa.basecrud.service.impl.AbstractBaseCrudService;
import com.university.doctoronline.entity.Ticket;
import com.university.doctoronline.entity.TicketStatus;
import com.university.doctoronline.entity.Timetable;
import com.university.doctoronline.entity.user.Patient;
import com.university.doctoronline.properties.TimetableProperties;
import com.university.doctoronline.repository.TicketRepository;
import com.university.doctoronline.search.TicketSearchCriteria;
import com.university.doctoronline.service.TicketService;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.JoinType;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static com.university.doctoronline.utils.SpecificationUtils.join;

@Service
public class TicketServiceImpl extends AbstractBaseCrudService<Ticket, TicketSearchCriteria> implements TicketService {

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
    public List<Ticket> findExpired(LocalDateTime localDateTime, List<TicketStatus> statuses) {
        return ticketRepository.findByTimeIsBeforeAndStatusIn(localDateTime, statuses);
    }

    @Override
    public Specification<Ticket> createSpecification(TicketSearchCriteria searchCriteria) {
        final Specification<Ticket> idPredicate = (root, query, builder) -> {
            final var id = searchCriteria.getId();
            if (id == null) {
                return null;
            }

            return builder.equal(root.get("id"), id);
        };

        final Specification<Ticket> patientPredicate = (root, query, builder) -> {
            final var patientId = searchCriteria.getPatientId();
            if (patientId == null) {
                return null;
            }

            return builder.equal(join(root, "patient", JoinType.INNER).get("id"), patientId);
        };

        final Specification<Ticket> statusPredicate = (root, query, builder) -> {
            final var status = searchCriteria.getStatus();
            if (status == null) {
                return null;
            }
            return builder.equal(root.get("status"), status);
        };

        return Specification.where(idPredicate).and(patientPredicate).and(statusPredicate);
    }
}
