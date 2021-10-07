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
    public void addUser(users newUsers) {
        newUsers.setPassword(passwordEncoder.encode(newUsers.getPassword()));
        newUsers.setRole("ADMIN");
        if (newUsers.getUsername().equals("")){
            throw  new IllegalArgumentException("usernam empty");
        }
        userRepo.save(newUsers);
    }
    public List<users> allUsers(){
        return userRepo.findAll();
    }

public void deleteUser(String id){

}
}
