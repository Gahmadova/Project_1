package repositories;

import entity.User;

import java.util.List;

public interface UserDAO {

    User  createUser(User user);

    // READ
    User getUserById(int id);
    User getUserByUsername(String username);
    List<User> getAllUsers();

    // UPDATE
    User UpdateUser(User user);
    User UpdateRole(int id);


    // DELETE
    boolean deleteUserById(int id);




}