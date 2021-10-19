package com.home.Recruitment_Project.Controller;


import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class Testcontroller {

    @CrossOrigin(origins = "*", maxAge = 3600)
    @RestController
    @RequestMapping("/api/test")
    public class TestController {

        @GetMapping("/all")
        public String allAccess() {
            return "Public Content.";
        }


        @GetMapping("/user")
        @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
        @CrossOrigin(origins = "http://localhost:4200")
        public String userAccess() {
            return "User Content.";
        }

    }
}