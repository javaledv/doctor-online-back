package com.university.doctoronline.dto.converter;

import com.university.doctoronline.dto.TicketDto;
import com.university.doctoronline.dto.TicketInfoDto;
import com.university.doctoronline.entity.Ticket;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

@Service
public class TicketInfoDtoConverter extends TicketDtoConverter {

    @Override
    public Ticket toEntity(TicketDto dto) {
        return super.toEntity(dto);
    }

    @Override
    public TicketInfoDto toDto(Ticket entity) {
        final var dto = new TicketInfoDto(super.toDto(entity));
        final var doctor = entity.getTimetable().getDoctor();
        dto.setCabinet(doctor.getCabinet());
        dto.setDoctorName(doctor.getLastName() + StringUtils.SPACE + doctor.getFirstName() + StringUtils.SPACE + doctor.getMiddleName());

        return dto;
    }
}
