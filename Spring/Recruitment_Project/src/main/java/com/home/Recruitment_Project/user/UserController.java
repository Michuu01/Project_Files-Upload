package com.home.Recruitment_Project.user;

import com.home.Recruitment_Project.repository.UserRepo;
import lombok.SneakyThrows;
import org.springframework.expression.ExpressionException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    private UserService userService;
    private UserRepo userRepo;

    public UserController(UserService userService, UserRepo userRepo) {
        this.userService = userService;
        this.userRepo = userRepo;
    }

    @PostMapping("/register")
    @CrossOrigin(origins = "http://localhost:4200")
    public UserApp register(@RequestBody UserApp newUser) {
        String tempEmail = newUser.getEmail();
        if (tempEmail != null) {
            UserApp userObj = userService.fetchUserByEmail(tempEmail);
            if (userObj != null) {
                throw new ExpressionException("user with" + tempEmail + "is already exist");
            }
        }
        UserApp userObj = null;
        userObj = userService.addUser(newUser);
        return userObj;
    }

    @SneakyThrows
    @PostMapping("/login")
    @CrossOrigin(origins = "http://localhost:4200")
    public UserApp loginUser(@RequestBody UserApp userLogin) {
        String username = userLogin.getUsername();
        String password = userLogin.getPassword();
        UserApp userObj = null;
        if (username != null && password != null) {
            userObj = userService.fetchUserByUsernameAndPassword(username, password);
        }
        if (userObj == null) {
            throw new Exception("Bad credentials");
        }
        return userObj;
    }


    @GetMapping("/loginsuccess")
    public String hello() {
        return "Hello everyone";
    }

    @GetMapping("/getusers")
    public List<UserApp> getUser() {
        return userService.allUsers();
    }


}
