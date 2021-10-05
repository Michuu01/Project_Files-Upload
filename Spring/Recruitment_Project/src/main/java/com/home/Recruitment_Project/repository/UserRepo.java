package com.home.Recruitment_Project.repository;

import com.home.Recruitment_Project.user.users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<users, Long> {
    users findByUsername(String username);
}
