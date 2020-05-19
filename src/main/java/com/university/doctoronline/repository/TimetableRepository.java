package com.university.doctoronline.repository;

import com.reserver.common.starter.data.jpa.basecrud.repository.BaseCrudRepository;
import com.university.doctoronline.entity.Timetable;
import com.university.doctoronline.entity.user.Doctor;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface TimetableRepository extends BaseCrudRepository<Timetable> {

    List<Timetable> getAllByDoctorAndDayBetweenOrderByDayAsc(Doctor doctor, LocalDate start, LocalDate end);

    Optional<Timetable> getByDoctorAndDay(Doctor doctor, LocalDate date);
}
