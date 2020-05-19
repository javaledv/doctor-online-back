package com.university.doctoronline.service.impl;

import com.reserver.common.starter.data.jpa.basecrud.service.impl.AbstractBaseCrudService;
import com.university.doctoronline.entity.Timetable;
import com.university.doctoronline.entity.user.Doctor;
import com.university.doctoronline.repository.TimetableRepository;
import com.university.doctoronline.search.IdSearchCriteria;
import com.university.doctoronline.service.TicketService;
import com.university.doctoronline.service.TimetableService;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class TimetableServiceImpl extends AbstractBaseCrudService<Timetable, IdSearchCriteria> implements TimetableService {

    private final TicketService ticketService;
    private final TimetableRepository timetableRepository;

    public TimetableServiceImpl(TicketService ticketService, TimetableRepository timetableRepository) {
        super(timetableRepository);
        this.ticketService = ticketService;
        this.timetableRepository = timetableRepository;
    }

    @Override
    public Specification<Timetable> createSpecification(IdSearchCriteria searchCriteria) {
        return null;
    }

    @Override
    public List<Timetable> getAllForDoctorBetween(Doctor doctor, LocalDate start, LocalDate end) {
        return timetableRepository.getAllByDoctorAndDayBetweenOrderByDayAsc(doctor, start, end);
    }

    @Override
    public List<Timetable> generate(Doctor doctor, int daysAmount) {
        final var now = LocalDate.now();
        final var timetables = timetableRepository.getAllByDoctorAndDayBetweenOrderByDayAsc(doctor, now, now.plusDays(daysAmount));
        if (timetables.size() == daysAmount) {
            return timetables;
        }

        final var totalAmount = timetables.size();
        final var toCreate = daysAmount - totalAmount;
        var lastDay = totalAmount == 0 ? LocalDate.now() : timetables.get(totalAmount - 1).getDay();

        for (int i = 0; i < toCreate; i++) {
            final var timetable = new Timetable();
            timetable.setDoctor(doctor);
            timetable.setDay(lastDay.plusDays(1));

            //TODO replace to app properties hardcoded values
            final var startAppointmentTime = LocalDateTime.of(lastDay, LocalTime.of(ThreadLocalRandom.current().nextInt(8, 13), 0, 0));
            timetable.setStartAppointmentTime(startAppointmentTime);
            timetable.setFinishAppointmentTime(startAppointmentTime.plusHours(5));

            lastDay = lastDay.plusDays(1);

            final var saved = this.save(timetable);
            saved.setTickets(ticketService.generate(saved));

            timetables.add(this.save(saved));
        }

        return timetables;
    }

    @Override
    public Optional<Timetable> getBy(Doctor doctor, LocalDate date) {
        return timetableRepository.getByDoctorAndDay(doctor, date);
    }
}
