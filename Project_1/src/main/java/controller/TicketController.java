package controller;

import com.google.gson.Gson;

import entity.Ticket;
import io.javalin.http.Handler;
import service.TicketService;

public class TicketController {
    public Handler createTicket = (ctx) ->{
        // get body from request
        String json = ctx.body();

        // deserializes json into target2
        Gson gson = new Gson();
        Ticket ticket = gson.fromJson(json, Ticket.class);

        // pass to the service later for verification and then DB creation
        Ticket registeredTicket = TicketService.getTicketService().createTicket(ticket);

        // convert ticket object into a JSON object for the response
        String ticketJson = gson.toJson(registeredTicket);
        ctx.status(201); //This is a status code that will tell us how things went
        ctx.result(ticketJson);
    };

    public Handler deleteTicket = (ctx) ->{
        ctx.result("deleteTicket");
    };

    public Handler updateTicket = (ctx) ->{
        ctx.result("updateTicket");
    };

    public Handler getTicket = (ctx) ->{
        ctx.result("getTicket");
    };
}