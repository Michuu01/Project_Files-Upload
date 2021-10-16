package com.home.Recruitment_Project.repository;


import com.home.Recruitment_Project.data.UserApp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<UserApp, Long> {
    Optional<UserApp> findByUsername(String username);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);
}