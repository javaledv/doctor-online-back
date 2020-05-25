package com.university.doctoronline.dto;

import com.university.doctoronline.entity.TicketStatus;

import java.time.LocalDateTime;

public class TicketDto extends BaseDto {

    protected LocalDateTime time;

    protected TicketStatus ticketStatus;

    protected Long timetableId;

    protected Long userId;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public TicketStatus getTicketStatus() {
        return ticketStatus;
    }

    public void setTicketStatus(TicketStatus ticketStatus) {
        this.ticketStatus = ticketStatus;
    }

    public Long getTimetableId() {
        return timetableId;
    }

    public void setTimetableId(Long timetableId) {
        this.timetableId = timetableId;
    }
}
