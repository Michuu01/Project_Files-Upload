package com.home.Recruitment_Project.user;

import com.home.Recruitment_Project.data.UserApp;
import com.home.Recruitment_Project.repository.UserRepo;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private UserRepo userRepo;

    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }


    public UserApp addUser(UserApp newUser) {

        for (int i = 0; i < newUser.getEmail().length(); i++)
            if (Character.isUpperCase(newUser.getEmail().charAt(i))) {
                throw new IllegalArgumentException("Email must be in lowercase");
            }
        if (!newUser.getEmail().contains("@")) {
            throw new IllegalArgumentException("you don't have a '@' ");
        }
        if (!newUser.getEmail().contains(".")) {
            throw new IllegalArgumentException("you don't have a dot ");
        }

        return userRepo.save(newUser);
    }
}
