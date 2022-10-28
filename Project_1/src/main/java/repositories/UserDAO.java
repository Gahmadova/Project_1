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


    // DELETE
    boolean deleteUserById(int id);

    User createEmployee(User new_User);

    User getEmployeeById(int id);
}