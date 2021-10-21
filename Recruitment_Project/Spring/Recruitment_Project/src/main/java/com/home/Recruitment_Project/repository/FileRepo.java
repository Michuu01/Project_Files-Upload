package com.home.Recruitment_Project.repository;

import com.home.Recruitment_Project.file.File;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface FileRepo extends JpaRepository<File, String> {

//File findByfileName(String fileName);
}
