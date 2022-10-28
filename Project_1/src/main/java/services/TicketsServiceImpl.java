package services;

import entity.Tickets;
import repositories.TicketsDAO;

import java.util.List;

public class TicketsServiceImpl implements TicketService {
    private TicketsDAO ticketsDAO;
    public TicketsServiceImpl(TicketsDAO ticketsDAO){
        this.ticketsDAO=ticketsDAO;
    }


    @Override
    public Tickets createTickets(Tickets tickets) {
        if(tickets.getDescriptions().length() == 0){
            throw new RuntimeException("Description cannot be empty!");
    }
        if(tickets.getAmount() <= 0 || tickets.getAmount() > 100000){
            throw new RuntimeException("Amount cannot be zero and cannot exceed 100000 dollars.");
        }
        Tickets savedTickets = this.ticketsDAO.createTickets(tickets);
        System.out.println("This is from the ServiceIMPL" + savedTickets);
        return savedTickets;
    }

    @Override
    public Tickets getTicketsById(int id) {
        return this.ticketsDAO.getTicketsById(id);
    }

    @Override
    public List<Tickets> getPendingTickets() {
        return this.ticketsDAO.getPendingTickets();
    }

    @Override
    public List<Tickets> getAllTickets() {
        return this.ticketsDAO.getAllTickets();
    }

    @Override
    public Tickets updateTickets(Tickets tickets) {
        if(tickets.getDescriptions().length()==0){
            throw new RuntimeException("Descriptions can not be emppty!");
        }
        if(tickets.getAmount() <=0 || tickets.getAmount()>100000){
            throw new RuntimeException("Amount can not be less than 0 or exceed 1000000.");
        }
        return this.ticketsDAO.updateTickets(tickets);
    }

    @Override
    public boolean deleteTicketsById(int id) {
        return this.ticketsDAO.deleteTicketsById(id);
    }
}

