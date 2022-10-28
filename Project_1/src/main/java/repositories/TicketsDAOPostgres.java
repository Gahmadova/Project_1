package repositories;

import com.sun.org.apache.xerces.internal.util.Status;
import entity.Tickets;
import utility.ConnectionFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TicketsDAOPostgres implements TicketsDAO{
    @Override
    public Tickets createTickets(Tickets tickets) {
        System.out.println(tickets);
        try(Connection connection = ConnectionFactory.getConnection()) {
            String sql = "insert into tickets values(default, ?, ?, ? ,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setFloat(1, tickets.getAmount());
            preparedStatement.setString(2, tickets.getDescriptions());
            preparedStatement.setInt(3, tickets.getUkey());
            preparedStatement.setString(4, tickets.getStatus().name());

            preparedStatement.execute();
            ResultSet rs = preparedStatement.getGeneratedKeys();
            rs.next();
            int generatedKey = rs.getInt("id");
            tickets.setId(generatedKey);
            return tickets;

        }
        catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Tickets getTicketsById(int id) {
        // Checking for the connection to our database
        try(Connection connection = ConnectionFactory.getConnection()){

            // If the database connection is good, it will move on to create a sql string
            String sql = "select * from tickets where id = ?";

            // preparedstatement is a pre-compiled sql statement, we are creating one and passing in the
            // sql string that we just wrote.
            PreparedStatement ps = connection.prepareStatement(sql);

            //We set the value of the sql string that we created using preparedstatement by telling it
            //What we are inserting into the index of the "?"
            ps.setInt(1, id);

            // Setting the result value
            ResultSet rs = ps.executeQuery();

            //  moving the head
            rs.next();

            // Creating a new ticket object
            Tickets tickets = new Tickets();
            tickets.setId(rs.getInt("id"));
            tickets.setAmount(rs.getLong("amount"));
            tickets.setDescriptions(rs.getString("descriptions"));
            tickets.setStatus(Status.valueOf(rs.getString("status")));

            return tickets;
        }
        catch(SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Tickets> getPendingTickets() {
        try (Connection connection = ConnectionFactory.getConnection()) {
            String sql = "select * from tickets where status = 'PENDING'";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            List<Tickets> ticketsList = new ArrayList<>();

            while (rs.next()) {
                Tickets tickets = new Tickets();
                tickets.setId(rs.getInt("id"));
                tickets.setAmount(rs.getLong("amount"));
                tickets.setDescriptions(rs.getString("descriptions"));
                tickets.setStatus(Status.valueOf(rs.getString("status")));
                ticketsList.add(tickets);

            }
            return ticketsList;
        }
        catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Tickets> getAllTickets() {
        try (Connection connection = ConnectionFactory.getConnection()) {
            String sql = "select * from tickets";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            List<Tickets> ticketsList = new ArrayList<>();

            while (rs.next()) {
                Tickets tickets = new Tickets();
                tickets.setId(rs.getInt("id"));
                tickets.setAmount(rs.getLong("amount"));
                tickets.setDescriptions(rs.getString("descriptions"));
                tickets.setStatus(Status.valueOf(rs.getString("status")));
                ticketsList.add(tickets);



            }
            return ticketsList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Tickets updateTickets(Tickets tickets) {
        try(Connection connection = ConnectionFactory.getConnection()){
            String sql = "update ticket set amount = ?, descriptions = ?, status = ?";

            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setFloat(1, tickets.getAmount());
            ps.setString(2, tickets.getDescriptions());
            ps.setString(3, tickets.getStatus().name());

            ps.executeUpdate();
            return tickets;
        }
        catch(SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean deleteTicketsById(int id) {
        try(Connection connection = ConnectionFactory.getConnection()){
            String sql = "delete tickets where id = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);

            ps.execute();
            return true;
        }
        catch(SQLException e){
            e.printStackTrace();
            return false;
        }

    }
}
