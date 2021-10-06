package com.home.Recruitment_Project.user;

import com.home.Recruitment_Project.user.UserService;
import com.home.Recruitment_Project.user.users;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String hello() {
        return "Hello";

    }
    @GetMapping("/hello")
    public String hello2() {
        return "MODERATOR";

    }

    @GetMapping("/sing-up")
    public String signUp(Model model) {
        model.addAttribute("user", new users());
        return "Sing-up";
    }
    @PostMapping("/register")
    public String register(users users){
        userService.addUser(users);
    return "C:\\Project\\Spring\\Recruitment_Project\\src\\main\\resources\\templates\\Sing-up.html";
    }
}
