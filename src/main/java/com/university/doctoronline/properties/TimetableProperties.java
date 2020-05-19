package com.university.doctoronline.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("app.timetable")
public class TimetableProperties {

    private boolean autoGenerate = true;
    private int generationAmount = 30;
    private String generationJobCron;

    private int ticketAppointmentInterval = 10;

    public boolean isAutoGenerate() {
        return autoGenerate;
    }

    public void setAutoGenerate(boolean autoGenerate) {
        this.autoGenerate = autoGenerate;
    }

    public int getTicketAppointmentInterval() {
        return ticketAppointmentInterval;
    }

    public void setTicketAppointmentInterval(int ticketAppointmentInterval) {
        this.ticketAppointmentInterval = ticketAppointmentInterval;
    }

    public int getGenerationAmount() {
        return generationAmount;
    }

    public void setGenerationAmount(int generationAmount) {
        this.generationAmount = generationAmount;
    }

    public String getGenerationJobCron() {
        return generationJobCron;
    }

    public void setGenerationJobCron(String generationJobCron) {
        this.generationJobCron = generationJobCron;
    }
}
