package controller;

import com.google.gson.Gson;
import driver.Driver;
import entity.Login;
import entity.User;
import io.javalin.http.Handler;


import java.util.List;

public class UserContoller {
    public Handler createUser = (ctx) ->{
        String  json = ctx.body();
        Gson gson = new Gson();
        User user = gson.fromJson(json, User.class);
        User registeredUser = Driver.userService.createUser(user);
        if(registeredUser == null){
            ctx.status(400);
            ctx.result("Username already exists in the database.");
        }
        else {
            ctx.status(200);
            ctx.result("Your account has been created!");
        }
    };

    public Handler getUserByIdHandler = (ctx) ->{
        int id = Integer.parseInt(ctx.pathParam("id"));//This will take what value was in the {id} and turn it into an int for us to use
        User user = Driver.userService.getUserById(id);
        Gson gson = new Gson();
        String json = gson.toJson(user);
        ctx.result(json);
    };

    public Handler getAllUsers = (ctx) ->{
        List<User> users = Driver.userService.getAllUsers();
        Gson gson = new Gson();
        String json = gson.toJson(users);
        ctx.result(json);
    };

    public Handler updateUserHandler = (ctx) ->{
        String userJSON = ctx.body();
        Gson gson = new Gson();
        User user = gson.fromJson(userJSON, User.class);
        User updateUser = Driver.userService.UpdateUser(user);
        String json = gson.toJson(updateUser);
        ctx.result(json);
    };


    public Handler deleteUserHandler = (ctx) ->{
        int id = Integer.parseInt(ctx.pathParam("id"));
        boolean result = Driver.userService.deleteUserById(id);
        if(result){
            ctx.status(204);
        }
        else{
            ctx.status(400);
            ctx.result("Could not process your delete request");
        }
    };

    // Checking to make sure that the username and password we  receive
    // is from JSON and in the DB
    public Handler loginUserHandler = (ctx) ->{
        if(Driver.login == null){
            String  json = ctx.body();
            Gson gson = new Gson();
            Login login = gson.fromJson(json, Login.class);
            int authenticateUser = Driver.userService.authenticateUser(login.getUsername(), login.getPassword());
            if(authenticateUser == 1){
                ctx.status(202);
                ctx.result("Successful login!");
            }
            else if (authenticateUser == 2){
                ctx.status(404);
                ctx.result("Username was not found or invalid!");
            }
            else if (authenticateUser == 3){
                ctx.status(401);
                ctx.result("Password does not match!");
            }
//            String userJson = gson.toJson(authenticateUser);
//            ctx.status(201);
//            ctx.result(userJson);
        }
        else {
            ctx.status(403);
            ctx.result("SOMEONE IS USING THE RESTROOM! OCCUPIED!");
        }
    };

    public Handler logoutUserHandler = (ctx) ->{
        if(Driver.login != null){
            Driver.login = null;
            ctx.status(200);
            ctx.result("Successfully logged out!");
        }
        else {
            ctx.status(410);
            ctx.result("No one is logged in! RESTROOM VACANT!");
        }
    };
}
