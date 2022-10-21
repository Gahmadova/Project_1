package driver;

import controllers.BookController;
import handlers.HelloHandler;
import io.javalin.Javalin;
import repositories.BookDAO;
import repositories.BookDAOLocal;
import repositories.BookDAOPostGres;
import service.BookService;
import service.BookServiceImplement;

public class Driver {

    public static BookService bookService = new BookServiceImplement(new BookDAOPostGres());
    public static void main(String[] args) {
        Javalin app = Javalin.create();

        HelloHandler helloHandler = new HelloHandler();
        BookController bookController = new BookController();


        app.get("/hello", helloHandler);

        app.get("/books/{id}", bookController.getBookByIdHandler);

        app.post("/books", bookController.createBook);

        app.put("/books", bookController.updateBookHandler);

        app.delete("/books/{id}", bookController.deleteBookHandler);



        app.start();
    }
}
