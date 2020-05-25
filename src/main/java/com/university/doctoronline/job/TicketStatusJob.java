package com.university.doctoronline.job;

import com.university.doctoronline.entity.TicketStatus;
import com.university.doctoronline.service.TicketService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class TicketStatusJob {

    private final TicketService ticketService;

    public TicketStatusJob(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @Scheduled(cron = "${app.ticket.status-update-job-cron}")
    public void updated() {
        final var toSave = ticketService.findExpired(LocalDateTime.now(), List.of(TicketStatus.OPENED, TicketStatus.RESERVED)).stream()
                .peek(ticket -> ticket.setStatus(TicketStatus.EXPIRED))
                .collect(Collectors.toList());

        ticketService.saveAll(toSave);
    }
}
