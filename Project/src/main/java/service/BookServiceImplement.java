package service;

import entities.Book;
import exceptions.InvalidAuthorException;
import repositories.BookDAO;
import repositories.BookDAOLocal;

import java.sql.SQLInvalidAuthorizationSpecException;
import java.util.List;

public class BookServiceImplement implements BookService{
    private BookDAO bookDAO;
    public BookServiceImplement(BookDAO bookDAO){
        this.bookDAO=bookDAO;
    }


    @Override
    public Book createBook(Book book) {
        if(book.getTitle().length() == 0){
            throw new RuntimeException("Book's title cannot be empty");
        }
        if(book.getAuthor().length() == 0){
            throw new InvalidAuthorException("Book's authors cannot be empty");
        }
        Book savedBook = this.bookDAO.createBook(book);
        return savedBook;
    }

    @Override
    public Book getBookById(int id) {
        return this.bookDAO.getBookById(id);
    }

    @Override
    public List<Book> getAllBooks() {
        return this.bookDAO.getAllBooks();
    }

    @Override
    public Book updateBook(Book book) {
        if(book.getTitle().length()==0){
            throw new RuntimeException("Book's title can not be empty");
        }if(book.getAuthor().length()==0){
            throw new RuntimeException("Books authors can not be empty");
        }
        return this.bookDAO.updateBook(book);
    }

    @Override
    public boolean deleteBookById(int id) {
        return this.bookDAO.deleteBookById(id);
    }
}
