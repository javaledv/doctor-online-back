package com.university.doctoronline.dto.converter;

import com.university.doctoronline.dto.TimetableDto;
import com.university.doctoronline.entity.Timetable;
import com.university.doctoronline.service.TimetableService;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class TimetableDtoConverter implements DtoConverter<Timetable, TimetableDto> {

    private final TimetableService timetableService;
    private final TicketDtoConverter ticketDtoConverter;

    public TimetableDtoConverter(TimetableService timetableService, TicketDtoConverter ticketDtoConverter) {
        this.timetableService = timetableService;
        this.ticketDtoConverter = ticketDtoConverter;
    }

    @Override
    public Timetable toEntity(TimetableDto dto) {
        return null;
    }

    @Override
    public TimetableDto toDto(Timetable entity) {
        final var dto = new TimetableDto();
        dto.setId(entity.getId());
        dto.setDate(entity.getDay());
        dto.setDoctorId(entity.getDoctor().getId());
        dto.setStartAppointmentTime(entity.getStartAppointmentTime());
        dto.setFinishAppointmentTime(entity.getFinishAppointmentTime());
        dto.setTickets(entity.getTickets().stream().map(ticketDtoConverter::toDto).collect(Collectors.toList()));

        return dto;
    }
}
