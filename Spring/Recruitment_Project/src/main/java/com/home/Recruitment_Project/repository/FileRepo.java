package com.home.Recruitment_Project.repository;

import com.home.Recruitment_Project.user.users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FileRepo extends JpaRepository<users, Long> {
    Optional<users> findById(Long fileid);
}
