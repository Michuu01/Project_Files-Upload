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
