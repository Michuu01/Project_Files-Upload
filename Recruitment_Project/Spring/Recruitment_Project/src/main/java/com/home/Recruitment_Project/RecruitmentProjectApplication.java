package com.home.Recruitment_Project;

import com.home.Recruitment_Project.file.ResponseMessage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.MaxUploadSizeExceededException;

@SpringBootApplication
public class RecruitmentProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(RecruitmentProjectApplication.class, args);
	}


}
