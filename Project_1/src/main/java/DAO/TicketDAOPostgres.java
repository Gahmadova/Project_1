package DAO;

import dev.passos.entity.Ticket;
import dev.passos.interfaces.TicketCRUD;
import dev.passos.utility.DBConn;
import entity.Ticket;
import interfaces.TicketCRUD;

import java.sql.Connection;
import java.sql.SQLException;

public class TicketDAOPostgres implements TicketCRUD {

    private static TicketDAOPostgres db = null;

    public static TicketDAOPostgres getDB(){
        if(db == null){
            db = new TicketDAOPostgres();
        }
        return db;
    }


    @Override
    public Ticket createTicket(Ticket ticket) {
        try(Connection connection = DBConn.getConnection()){
            String sql = "insert into Ticket value(default, ?, ?, default, )";
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
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
