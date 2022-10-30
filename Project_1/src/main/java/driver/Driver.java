package driver;

import controller.TicketsController;
import controller.UserContoller;
import entity.User;
import io.javalin.Javalin;
import io.javalin.http.Handler;
import repositories.TicketsDAOPostgres;
import repositories.UserDAOPostgres;
import services.TicketService;
import services.TicketsServiceImpl;
import services.UserService;
import services.UserServiceImpl;

public class Driver {
    public static UserService userService = new UserServiceImpl(new UserDAOPostgres());
    public static TicketService ticketsService = new TicketsServiceImpl(new TicketsDAOPostgres());

    public static User login = null;

    public static void main(String[] args) {
        Javalin app = Javalin.create();

        UserContoller userContoller = new UserContoller();

        app.get("/user/{id}", (Handler) userContoller.getUserByIdHandler);
        app.get("/user", (Handler) userContoller.getAllUsers);
        app.post("/user", (Handler) userContoller.createUser);
        app.put("/user", (Handler) userContoller.updateUserHandler);
        app.delete("/user/{id}", (Handler) userContoller.deleteUserHandler);


        TicketsController ticketsController = new TicketsController();

        app.get("/tickets/byid/{id}", (Handler) ticketsController.getTicketsByIdHandler);
        app.get("/tickets", (Handler) ticketsController.getAllTickets);
        app.get("/tickets/pending", (Handler) ticketsController.getPendingTicketsHandler);
        app.post("/tickets", (Handler) ticketsController.createTickets);
        app.put("/tickets", (Handler) ticketsController.updateTicketsHandler);
        app.delete("/tickets/{id}", (Handler) ticketsController.deleteTicketsHandler);

        app.put("/updateStatus/{id}", ticketsController.updateStatusHandler); //
        app.get("/getUserTickets", ticketsController.getUserTicketsHandler);  //
        app.post("/login", (Handler) userContoller.loginUserHandler);
        app.get("/logout", (Handler) userContoller.logoutUserHandler);

        app.get("/getUserTickets/{rtypes}", ticketsController.getUserTicketsByrTypes);
       // app.put("/updaterole/{id}", userContoller.changeRoleHandler);


        app.start();
    }
}