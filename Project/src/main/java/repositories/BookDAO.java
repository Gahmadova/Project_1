package repositories;

import entities.Book;

import java.util.List;


public interface BookDAO {


    //create
    Book createBook(Book book);

    //read
    Book getBookById(int id);
    List<Book> getAllBooks();

    //update
    Book updateBook(Book book);

    //delete
    boolean deleteBookById(int id);


}
