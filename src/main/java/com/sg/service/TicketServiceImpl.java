package com.sg.service;

import com.sg.entity.Ticket;
import com.sg.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TicketServiceImpl implements TicketService {
    @Autowired
    private TicketRepository ticketRepository;

    @Override
    public Iterable<Ticket> listTickets() {
        return ticketRepository.findAll();
    }

    @Override
    public void saveTicket(Ticket ticket)
    {
        ticketRepository.save(ticket);
    }

    @Override
    public Ticket getTicket(long id){ return ticketRepository.findById(id).get();}

    @Override
    public void deleteTicket(long id){ ticketRepository.deleteById(id);}

}
