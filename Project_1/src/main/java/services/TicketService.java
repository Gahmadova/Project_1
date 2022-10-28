package services;

import entity.Tickets;

import java.util.List;

public interface TicketService {

    Tickets createTickets(Tickets tickets);

    Tickets getTicketsById(int id);

    List<Tickets> getPendingTickets();
    List<Tickets> getAllTickets();

    Tickets updateTickets(Tickets tickets);

    boolean deleteTicketsById(int id);


}
