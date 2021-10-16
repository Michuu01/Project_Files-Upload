package com.home.Recruitment_Project.Controller;;
import com.home.Recruitment_Project.file.File;
import com.home.Recruitment_Project.file.FileRequest;
import com.home.Recruitment_Project.file.FileService;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/File")
    public class FileController {

    FileService fileService;

    public FileController(FileService fileService) {
        this.fileService = fileService;
    }


    @PostMapping("/Upload")
        public FileRequest uploadFile(MultipartFile file) {
            File model = fileService.saveFile(file);
            String fileUri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/download/").
                    path(model.getFileId()).toUriString();
            return new FileRequest(model.getFileName(), model.getFileType(), fileUri);
        }

//        @PostMapping("/UploadMultipleFiles")
//        public List<FileRequest> uploadMultipleFiles(MultipartFile[] files) {
//            return Arrays.stream(files).
//                    map(this::uploadFile).
//                    collect(Collectors.toList());
//        }

        @GetMapping("/download/{fileName}")
        public ResponseEntity<ByteArrayResource> downloadFile(@PathVariable String fileName) {
            File model = fileService.getFile(fileName);
            return ResponseEntity.ok().
                    header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=\"" + model.getFileName() + "\"").
                    body(new ByteArrayResource(model.getFileData()));


        }

    }

