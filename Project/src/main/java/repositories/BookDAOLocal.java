package repositories;

import entities.Book;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookDAOLocal implements BookDAO{

    private Map<Integer,Book> bookTable = new HashMap();
    private int idCount = 1;


    @Override
    public Book createBook(Book book) {
        book.setId(idCount);
        idCount++;
        bookTable.put(book.getId(),book);
        System.out.println(bookTable.values());
        return book;
    }

    @Override
    public Book getBookById(int id) {

        return bookTable.get(id);
    }

    @Override
    public List<Book> getAllBooks() {
        return null;
    }

    @Override
    public Book updateBook(Book book) {
        return bookTable.put(book.getId(), book);

    }

    @Override
    public boolean deleteBookById(int id) {
        Book book = bookTable.remove(id);
        if(book == null){
            return true;
        }
        else {
            return false;
        }
    }
}
