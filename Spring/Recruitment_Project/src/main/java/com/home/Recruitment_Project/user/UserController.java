package com.home.Recruitment_Project.user;

import com.home.Recruitment_Project.repository.UserRepo;
import org.apache.catalina.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@RestController
public class UserController {

private UserService userService;
private UserRepo userRepo;

    public UserController(UserService userService, UserRepo userRepo) {
        this.userService = userService;
        this.userRepo = userRepo;
    }

    @GetMapping("/")
    public String hello() {
        return "Hello everyone";
    }
    @GetMapping("/getusers")
    public List<users> getUser (){
        return userService.allUsers();
    }
    @PostMapping("/register")
    public users register(@RequestBody users newUsers){
        userService.addUser(newUsers);
   return userRepo.save(newUsers);
    }
}
