package com.sg.service;

import com.sg.entity.Ticket;

public interface TicketService {
    Iterable<Ticket> listTickets();
    void saveTicket(Ticket ticket);
    Ticket getTicket(long id);
    void deleteTicket(long id);
}


