package services;

import driver.Driver;
import entity.User;
import repositories.UserDAO;

import java.util.List;

public class UserServiceImpl implements UserService {

    private UserDAO userDAO;
    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }
    @Override
    public User createUser(User user) {
        if(user.getUsername().length() == 0 || user.getPassword().length() == 0) {
            throw new RuntimeException("Username or password cannot be empty!");
        }
        if(this.userDAO.getUserByUsername(user.getUsername()) == null) {
            if(user.getUsername().toLowerCase().contains("revature")){
                user.setManager(true);
            }
            User savedUser = this.userDAO.createUser(user);
            return savedUser;
        }
        else {
//            throw new RuntimeException("User input Username already exists.");
            return null;
        }
    }

        @Override
        public User getUserById(int id) {
            return this.userDAO.getUserById(id);
        }

        @Override
        public User getUserByUsername(String username) {
            return this.userDAO.getUserByUsername(username);

        }

        @Override
        public int authenticateUser(String username, String password) {
            int returnval = 0;
            User checkUser = Driver.userService.getUserByUsername(username);
            System.out.println(checkUser);
            if(checkUser != null){
                if(checkUser.getPassword().equals(password)){
                    Driver.login = checkUser;
                    returnval = 1;
                }
                else {
//                throw new RuntimeException("Password is incorrect!");
                    returnval = 3;
                }
            }
            else {
//            throw new RuntimeException("User does not exist");
                returnval = 2;

            }
            System.out.println(returnval);
            return returnval;
        }

        @Override
        public List<User> getAllUsers() {
            return this.userDAO.getAllUsers();
        }

        @Override
        public User UpdateUser(User user) {
            if(user.getUsername().length() == 0){
                throw new RuntimeException("Username cannot be empty!");
            }
            if(user.getPassword().length() == 0){
                throw new RuntimeException("Password cannot be empty!");
            }

            return this.userDAO.UpdateUser(user);
        }

    @Override
    public User UpdateRole(int id) {
        if(Driver.login.isManager()){
            User check_user = this.userDAO.UpdateRole(id);
            return check_user;
        }
        return null;
    }

    @Override
        public boolean deleteUserById(int id) {
            return this.userDAO.deleteUserById(id);
        }
}