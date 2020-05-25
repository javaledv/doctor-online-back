package com.university.doctoronline.controller;

import com.university.doctoronline.dto.TicketInfoDto;
import com.university.doctoronline.dto.converter.TicketInfoDtoConverter;
import com.university.doctoronline.entity.Ticket;
import com.university.doctoronline.entity.TicketStatus;
import com.university.doctoronline.search.TicketSearchCriteria;
import com.university.doctoronline.service.TicketService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/ticket")
public class TicketController {

    private final TicketService ticketService;
    private final TicketInfoDtoConverter ticketInfoDtoConverter;

    public TicketController(TicketService ticketService, TicketInfoDtoConverter ticketInfoDtoConverter) {
        this.ticketService = ticketService;
        this.ticketInfoDtoConverter = ticketInfoDtoConverter;
    }

    @GetMapping("/list")
    public Page<TicketInfoDto> getAll(@Valid TicketSearchCriteria searchCriteria, @PageableDefault() Pageable pageable) {
        return ticketService.getPage(searchCriteria, pageable).map(ticketInfoDtoConverter::toDto);
    }
}
