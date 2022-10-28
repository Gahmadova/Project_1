package controller;

import com.google.gson.Gson;
import driver.Driver;
import entity.Tickets;
import io.javalin.http.Handler;


import java.util.List;

public class TicketsController {


    public Handler createTickets = (ctX) ->{
        String json = ctX.body();
        Gson gson = new Gson();
        Tickets tickets = gson.fromJson(json, Tickets.class);
        Tickets registeredTickets = Driver.ticketsService.createTickets(tickets);
        String userJson = gson.toJson(registeredTickets);
        ctX.status(201);
        ctX.result(userJson);
    };

    public Handler getTicketsByIdHandler = (ctx) ->{
        int id = Integer.parseInt(ctx.pathParam("id"));
        Tickets tickets = Driver.ticketsService.getTicketsById(id);
        Gson gson = new Gson();
        String json = gson.toJson(tickets);
        ctx.result(json);
    };

    public Handler getAllTickets = (ctx) ->{
        List<Tickets> tickets = Driver.ticketsService.getAllTickets();
        Gson gson = new Gson();
        String json = gson.toJson(tickets);
        ctx.result(json);
    };

    public Handler updateTicketsHandler = (ctx) ->{
        String userJson = ctx.body();
        Gson gson = new Gson();
        Tickets tickets =  gson.fromJson(userJson, Tickets.class);
        Tickets updateTickets = Driver.ticketsService.updateTickets(tickets);
        String json = gson.toJson(updateTickets);
        ctx.result(json);
    };

    public Handler deleteTicketsHandler = (ctx) ->{
        int id = Integer.parseInt(ctx.pathParam("id"));
        boolean result =  Driver.ticketsService.deleteTicketsById(id);
        if(result){
            ctx.status(204);
        }
        else{
            ctx.status(400);
            ctx.result("Could not process delete ticket request!");
        }
    };

    public Handler getPendingTicketsHandler = (ctx) ->{
        System.out.println(ctx.path());
        List<Tickets> tickets = Driver.ticketsService.getPendingTickets();
        Gson gson = new Gson();
        String json = gson.toJson(tickets);
        ctx.result(json);
    };

}

