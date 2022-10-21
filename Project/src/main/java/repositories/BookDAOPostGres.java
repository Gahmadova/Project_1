package repositories;

import entities.Book;
import utilities.ConnectionFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookDAOPostGres implements BookDAO{
    @Override
    public Book createBook(Book book) {

        try(Connection connection = ConnectionFactory.getConnection()){

            String sql = "insert into books values(default, ?, ? , ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, book.getTitle());
            preparedStatement.setString(2,book.getAuthor());
            preparedStatement.setLong(3,book.getReturnDate());

            preparedStatement.execute();

            ResultSet resultSet = preparedStatement.getGeneratedKeys();//this returns the id that was created
            resultSet.next();//you need to move the cursor to the first valid record, or you will get a null response
            int generatedKey = resultSet.getInt("id");
            book.setId(generatedKey);
            return book;
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Book getBookById(int id) {
        try(Connection connection = ConnectionFactory.getConnection()){
            String sql = "select * from books where id = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            // The class PreparedStatement has a method called prepareStatement (no d) that takes in a string
            ps.setInt(1,id);

            ResultSet rs = ps.executeQuery();
            rs.next();

            Book book = new Book();
            book.setId(rs.getInt("id"));
            book.setTitle(rs.getString("title"));
            book.setAuthor(rs.getString("author"));
            book.setReturnDate(rs.getLong("returnDate"));

            return book;

        }
        catch (SQLException e){
            e.printStackTrace();
            return null;
        }



    }

    @Override
    public List<Book> getAllBooks() {
        try(Connection connection = ConnectionFactory.getConnection()){
            String sql = "select * from books";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            ResultSet rs = preparedStatement.executeQuery();

            List<Book> bookList = new ArrayList();

            while(rs.next()){
                Book book = new Book();
                book.setId(rs.getInt("id"));
                book.setTitle(rs.getString("title"));
                book.setAuthor(rs.getString("author"));
                book.setReturnDate(rs.getLong("returnDate"));
                bookList.add(book);
            }
            return bookList;

        }
        catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Book updateBook(Book book) {
        try(Connection connection = ConnectionFactory.getConnection()){
            String sql = "update books set title = ?, author = ?, returnDate = ? where id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, book.getTitle());
            preparedStatement.setString(2,book.getAuthor());
            preparedStatement.setLong(3,book.getReturnDate());
            preparedStatement.setInt(4,book.getId());

            preparedStatement.executeUpdate();
            return book;
        }
        catch (SQLException e){
            e.printStackTrace();
            return null;
        }

    }


    @Override
    public boolean deleteBookById(int id) {
        try(Connection connection = ConnectionFactory.getConnection()){
            String sql = "delete from books where id =?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1,id);

            preparedStatement.execute();
            return true;
        }
        catch (SQLException e){
            e.printStackTrace();
            return false;
        }
    }
}