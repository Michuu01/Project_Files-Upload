package com.home.Recruitment_Project.file;
import com.home.Recruitment_Project.file.File;
import com.home.Recruitment_Project.repository.FileRepo;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import java.util.Objects;

@Service
public class FileService {


    FileRepo fileRepo;

    public FileService(FileRepo fileRepo) {
        this.fileRepo = fileRepo;
    }

    @SneakyThrows
    public File saveFile(MultipartFile file) {
        String fileName = StringUtils.cleanPath(Objects.requireNonNull(file.getOriginalFilename()));

        File filee = new File(fileName, file.getContentType(), file.getBytes());
        System.out.println(fileName);
        return fileRepo.save(filee);

    }

    public File getFile(String fileId) {
        return fileRepo.findById(fileId).orElseThrow(() -> new RuntimeException("Error FIle"));
    }
}
