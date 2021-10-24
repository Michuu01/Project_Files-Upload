package com.home.Recruitment_Project.Controller;;
import com.home.Recruitment_Project.file.File;
import com.home.Recruitment_Project.file.FileRequest;
import com.home.Recruitment_Project.file.FileService;
import com.home.Recruitment_Project.file.ResponseMessage;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/File")


public class FileController {

    FileService fileService;


    public FileController(FileService fileService) {
        this.fileService = fileService;

    }

    @PostMapping("/Upload")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") MultipartFile file) {
        String message = "";
        try {
            fileService.saveFile(file);
            message = "Uploaded the file successfully: " + file.getOriginalFilename();
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
        } catch (Exception e) {
            message = "Could not upload the file: " + file.getOriginalFilename() + "!";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
        }
    }

    @GetMapping("/download/{fileName}")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<ByteArrayResource> downloadFile(@PathVariable String fileName) {
        File model = fileService.getFile(fileName);
        return ResponseEntity.ok().
                header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=\"" + model.getFileName() + "\"").
                body(new ByteArrayResource(model.getFileData()));
        }
    @GetMapping("/delete/{fileName}")
    @CrossOrigin(origins = "http://localhost:4200")
    public void  deleteFiles(@PathVariable String fileName) {
        fileService.deleteFile(fileName);
    }

    @GetMapping("/Allfiles")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<List<FileRequest>> getListFiles() {
        List<FileRequest> files = fileService.getAllFiles().map(file -> {
            String fileDownloadUri = ServletUriComponentsBuilder
                    .fromCurrentContextPath()
                    .path("/File/download/")
                    .path(file.getFileId())
                    .toUriString();
            String fileDeleteUri = ServletUriComponentsBuilder
                    .fromCurrentContextPath()
                    .path("/File/delete/")
                    .path(file.getFileId())
                    .toUriString();
            return new FileRequest(
                    file.getFileName(),
                    file.getFileType(),
                    fileDownloadUri,
                    fileDeleteUri,
                    file.getFileData().length,
                    file.getLocalDate());
        }).collect(Collectors.toList());

        return ResponseEntity.status(HttpStatus.OK).body(files);
    }
    }


