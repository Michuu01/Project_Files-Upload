package com.home.Recruitment_Project;


import com.home.Recruitment_Project.repository.UserRepo;

import com.home.Recruitment_Project.user.UserApp;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class UserSave {


    public UserSave(UserRepo userRepo, PasswordEncoder passwordEncoder) {
        UserApp a = new UserApp();
        a.setUsername("Michu");
        a.setPassword(passwordEncoder.encode("Michu123"));
        a.setRole("ROLE_ADMIN");
        a.setEmail("DAda");

        UserApp b = new UserApp();
        b.setUsername("Adam");
        b.setPassword
                ("Adam");
        b.setRole("ROLE_MODERATOR");


        userRepo.save(a);
        userRepo.save(b);


    }


}
