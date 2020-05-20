package com.university.doctoronline.controller;

import com.reserver.common.starter.data.jpa.basecrud.entity.BaseEntity;
import com.university.doctoronline.dto.TimetableDto;
import com.university.doctoronline.dto.converter.TimetableDtoConverter;
import com.university.doctoronline.entity.user.Doctor;
import com.university.doctoronline.exception.NotFoundException;
import com.university.doctoronline.service.DoctorService;
import com.university.doctoronline.service.TimetableService;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@RestController
@RequestMapping("/timetable")
public class TimetableController {

    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-d");

    private final TimetableDtoConverter timetableDtoConverter;
    private final TimetableService timetableService;
    private final DoctorService doctorService;

    public TimetableController(TimetableDtoConverter timetableDtoConverter, TimetableService timetableService, DoctorService doctorService) {
        this.timetableDtoConverter = timetableDtoConverter;
        this.timetableService = timetableService;
        this.doctorService = doctorService;
    }

    @Transactional
    @MessageMapping("/timetable/{id}")
    //@SendTo("/topic/timetable/{id}")
    public TimetableDto getTimeTable(@DestinationVariable Long id) {
        return timetableDtoConverter.toDto(timetableService.getById(id).orElseThrow(NotFoundException::new));
    }

    @GetMapping("/id")
    public Long getId(@RequestParam("doctorId") Doctor doctor, @RequestParam("date") String date) {
        return timetableService.getBy(doctor, LocalDate.parse(date, DATE_TIME_FORMATTER)).map(BaseEntity::getId).orElseThrow(NotFoundException::new);
    }
}
