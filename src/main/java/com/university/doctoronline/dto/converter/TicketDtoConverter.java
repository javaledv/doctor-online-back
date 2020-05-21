package com.university.doctoronline.dto.converter;

import com.university.doctoronline.dto.TicketDto;
import com.university.doctoronline.entity.Ticket;
import org.springframework.stereotype.Service;

@Service
public class TicketDtoConverter implements DtoConverter<Ticket, TicketDto> {

    @Override
    public Ticket toEntity(TicketDto dto) {
        return null;
    }

    @Override
    public TicketDto toDto(Ticket entity) {
        final var dto = new TicketDto();
        dto.setId(entity.getId());
        dto.setTimetableId(entity.getTimetable().getId());
        dto.setTime(entity.getTime());
        dto.setTicketStatus(entity.getStatus());
        if (entity.getPatient() != null) {
            dto.setUserId(entity.getPatient().getId());
        }

        return dto;
    }
}
