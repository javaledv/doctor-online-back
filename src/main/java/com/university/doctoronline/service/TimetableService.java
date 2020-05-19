package com.university.doctoronline.service;

import com.reserver.common.starter.data.jpa.basecrud.service.BaseCrudService;
import com.university.doctoronline.entity.Timetable;
import com.university.doctoronline.entity.user.Doctor;
import com.university.doctoronline.search.IdSearchCriteria;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface TimetableService extends BaseCrudService<Timetable, IdSearchCriteria> {

    List<Timetable> getAllForDoctorBetween(Doctor doctor, LocalDate start, LocalDate end);

    List<Timetable> generate(Doctor doctor, int daysAmount);

    Optional<Timetable> getBy(Doctor doctor, LocalDate date);
}
