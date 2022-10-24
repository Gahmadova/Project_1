package service;

import DecentralizedAO.TicketDAOPostgres;
import entity.Ticket;
import coalition.TicketCRUD;

public class TicketService implements TicketCRUD {

    private static TicketService ticketService = null;

    public static TicketService getTicketService(){
        if (ticketService == null) {
            ticketService = new TicketService();
        }
        return ticketService;
    }


    @Override
    public Ticket createTicket(Ticket ticket) {
        // verifications checks

        // create ticket in database
        Ticket registeredTicket = TicketDAOPostgres.getDB().createTicket(ticket);

        return registeredTicket;
    }


    @Override
    public Ticket getTicket(int id) {
        return null;
    }


    @Override
    public Ticket updateTicket(int id) {
        return null;
    }


    @Override
    public boolean deleteTicket(int id) {
        return false;
    }
}
