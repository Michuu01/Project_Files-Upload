package com.home.Recruitment_Project.user;

import com.home.Recruitment_Project.repository.UserRepo;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private UserRepo userRepo;
    private PasswordEncoder passwordEncoder;

    public UserService(UserRepo userRepo, PasswordEncoder passwordEncoder) {
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
    }


    public UserApp addUser(UserApp newUserApp) {

        if (newUserApp.getEmail() == null) {
            throw new IllegalArgumentException("Null problem");
        }
        if (newUserApp.getPassword() == null) {
            throw new IllegalArgumentException("Null problem");
        }
        if (newUserApp.getUsername() == null) {
            throw new IllegalArgumentException("Null problem");
        }

        for (int i = 0; i < newUserApp.getEmail().length(); i++)
            if (Character.isUpperCase(newUserApp.getEmail().charAt(i))) {
                throw new IllegalArgumentException("Email must be in lowercase");
            }
        if (!newUserApp.getEmail().contains("@")) {
            throw new IllegalArgumentException("you don't have a '@' ");
        }
        if (!newUserApp.getEmail().contains(".")) {
            throw new IllegalArgumentException("your email is invalid ");
        }

        newUserApp.setRole("ADMIN");
        return userRepo.save(newUserApp);
    }

    public UserApp fetchUserByEmail(String email) {
        return userRepo.findByEmail(email);
    }

    public UserApp fetchUserByUsernameAndPassword(String username, String password) {
        return userRepo.findByUsernameAndPassword(username, password);
    }


    public List<UserApp> allUsers() {
        return userRepo.findAll();
    }

    public void deleteUser(String id) {

    }
}
