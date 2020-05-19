package com.university.doctoronline.job;

import com.university.doctoronline.properties.TimetableProperties;
import com.university.doctoronline.service.DoctorService;
import com.university.doctoronline.service.TimetableService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class TimetableGenerationJob {

    private final DoctorService doctorService;
    private final TimetableProperties timetableProperties;
    private final TimetableService timetableService;

    public TimetableGenerationJob(DoctorService doctorService,
                                  TimetableProperties timetableProperties,
                                  TimetableService timetableService) {
        this.doctorService = doctorService;
        this.timetableProperties = timetableProperties;
        this.timetableService = timetableService;
    }

    @Scheduled(cron = "${app.timetable.generation-job-cron}")
    public void generateTimeTable() {
        if (timetableProperties.isAutoGenerate()) {
            doctorService.getAll()
                    .forEach(doctor -> timetableService.generate(doctor, timetableProperties.getGenerationAmount()));
        }
    }
}
