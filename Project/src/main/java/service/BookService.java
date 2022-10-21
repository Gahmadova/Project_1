package service;

import entities.Book;

import java.util.List;

public interface BookService {

    Book createBook(Book book);

    Book getBookById(int id);
    List<Book> getAllBooks();

    Book updateBook(Book book);
    boolean deleteBookById(int id);

}
