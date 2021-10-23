package com.home.Recruitment_Project.Controller;


import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/test")
public class Testcontroller {

        @GetMapping("/user")
        @CrossOrigin(origins = "http://localhost:4200")
        @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
        public String userAccess() {
            return "User Content.";
        }


    @GetMapping("/all")
    @CrossOrigin(origins = "http://localhost:4200")
    public String all() {
        return "Public Content.";
    }


}