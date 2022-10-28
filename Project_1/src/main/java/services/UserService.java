package services;

import entity.User;

import java.util.List;

public interface UserService {

    // CREATE
    User createUser(User user);

    // READ
    User getUserById(int id);

    User getUserByUsername(String username);

    int authenticateUser(String username, String password);

    List<User> getAllUsers();

    // UPDATE
    User UpdateUser(User user);

    // DELETE
    boolean deleteUserById(int id);
}