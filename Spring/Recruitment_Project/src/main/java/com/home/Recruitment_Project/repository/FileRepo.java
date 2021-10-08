package com.home.Recruitment_Project.repository;

import com.home.Recruitment_Project.user.UserApp;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FileRepo extends JpaRepository<UserApp, Long> {
    Optional<UserApp> findById(Long fileid);
}
