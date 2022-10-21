package DAOTest;

import entities.Book;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import repositories.BookDAO;
import repositories.BookDAOLocal;
import repositories.BookDAOPostGres;

public class BookDAOTest {

    static BookDAO bookDAO = new BookDAOPostGres();
     @Test
    void create_book_test(){
        Book newBook = new Book(0,"Pater Pan","Robin Williams",0);
         Book savedBook = bookDAO.createBook(newBook);
        Assertions.assertNotEquals(0,savedBook.getId());

    }
    @Test
    @Order(2)
    void get_book_by_id_test(){
         Book gottenBook = bookDAO.getBookById(1);
         Assertions.assertEquals("Pater Pan",gottenBook.getTitle());
    }
    @Test
    @Order(3)
    void update_book_test(){
         Book book = bookDAO.getBookById(1);
         Book bookV2 = new Book(book.getId(),book.getTitle(), "James Matthew",book.getReturnDate());
         bookDAO.updateBook(bookV2);
         Book updateBook = bookDAO.getBookById(bookV2.getId());
         Assertions.assertEquals("James Matthew",updateBook.getAuthor());
    }
    @Test
    @Order(4)
    void delete_book_by_id_test(){
         boolean result = bookDAO.deleteBookById(1);
         Assertions.assertTrue(result);
    }
}
