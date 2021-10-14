package com.home.Recruitment_Project.repository;

import com.home.Recruitment_Project.user.UserApp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<UserApp, Long> {
    UserApp findByEmail(String EmailR);
    UserApp findByUsernameAndPassword(String username, String password);


}
