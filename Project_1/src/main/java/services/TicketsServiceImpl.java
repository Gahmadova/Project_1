package services;

import driver.Driver;
import entity.Status;
import entity.Tickets;
import repositories.TicketsDAO;

import java.util.ArrayList;
import java.util.List;

public class TicketsServiceImpl implements TicketService {
    private TicketsDAO ticketsDAO;
    public TicketsServiceImpl(TicketsDAO ticketsDAO){
        this.ticketsDAO=ticketsDAO;
    }


    @Override
    public Tickets createTickets(Tickets tickets) {
        System.out.println(tickets);
        if(tickets.getDescriptions() == null || tickets.getDescriptions().length()==0){
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
    public List<Tickets> getUserTicketsbyType(int id, String rtypes) {
        List<Tickets> ticketsList = this.ticketsDAO.getUserTickets(id);
        List<Tickets> returnTickets = new ArrayList<>();
        for(Tickets T: ticketsList){
            if(T.getrtypes().equals(rtypes)){
                returnTickets.add(T);
            }
        }
        return returnTickets;
    }

    @Override
    public List<Tickets> getPendingTickets() {
        if (Driver.login.isManager()) {
            return this.ticketsDAO.getPendingTickets();
        } else {
            throw new RuntimeException("You don't have permission to view PENDING tickets");
        }
    }
    @Override
    public List<Tickets> getAllTickets() {
        return this.ticketsDAO.getAllTickets();
    }
    @Override
    public List<Tickets> getUserTickets(int id){
        return this.ticketsDAO.getUserTickets(id);
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
    public Tickets updateStatus(Tickets tickets) {
        if (Driver.login.isManager()) {
            Tickets check_tickets = this.ticketsDAO.getTicketsById(tickets.getId());
            if(check_tickets.getStatus().equals(Status.PENDING)) {
                Tickets new_tickets = ticketsDAO.updateStatus(tickets);
                return new_tickets;
            }
        }
        else {
            throw new RuntimeException("YOU DO NOT HAVE PERMISSION TO CHANGE TICKET STATUS!");
        }
        return null;
    }


    @Override
    public boolean deleteTicketsById(int id) {
        return this.ticketsDAO.deleteTicketsById(id);
    }
}

