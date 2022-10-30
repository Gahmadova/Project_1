package repositories;


import entity.Tickets;

import java.util.List;


public interface TicketsDAO {
   // CRUD IMPLEMENTATION

      Tickets createTickets(Tickets tickets);

      Tickets getTicketsById(int id);
      List<Tickets> getPendingTickets();

      List<Tickets> getAllTickets();

      List<Tickets> getUserTickets(int id);

      Tickets updateTickets(Tickets tickets);
      Tickets updateStatus(Tickets tickets);

      boolean deleteTicketsById(int id);
}
