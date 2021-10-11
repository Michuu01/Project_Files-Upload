package com.home.Recruitment_Project.repository;

import com.home.Recruitment_Project.file.File;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileRepo extends JpaRepository<File, String> {

}
