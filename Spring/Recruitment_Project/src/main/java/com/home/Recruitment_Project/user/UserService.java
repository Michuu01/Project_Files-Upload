package com.home.Recruitment_Project.user;

import com.home.Recruitment_Project.repository.UserRepo;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserRepo userRepo;
    private PasswordEncoder passwordEncoder;


    public UserService(UserRepo userRepo, PasswordEncoder passwordEncoder) {
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
    }


    public void addUser(users users) {
        if (users.getUsername().equals("dupa")) {
            throw new IllegalArgumentException("dsada");
        }
        users.setPassword(passwordEncoder.encode(users.getPassword()));
        users.setRole("ADMIN");
        userRepo.save(users);


    }
}
