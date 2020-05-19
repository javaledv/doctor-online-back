package com.university.doctoronline.service;

import com.reserver.common.starter.data.jpa.basecrud.service.BaseCrudService;
import com.university.doctoronline.entity.Ticket;
import com.university.doctoronline.entity.Timetable;
import com.university.doctoronline.search.IdSearchCriteria;

import java.util.List;

public interface TicketService extends BaseCrudService<Ticket, IdSearchCriteria> {

    List<Ticket> generate(Timetable timetable);
}
