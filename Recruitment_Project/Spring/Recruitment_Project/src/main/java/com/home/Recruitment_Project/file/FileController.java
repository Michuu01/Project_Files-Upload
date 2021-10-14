package com.home.Recruitment_Project.file;;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.Arrays;
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
        public FileResponse uploadFile(MultipartFile file) {
            File model = fileService.saveFile(file);
            String fileUri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/download/").
                    path(model.getFileId()).toUriString();
            return new FileResponse(model.getFileName(), model.getFileType(), fileUri);
        }

//        @PostMapping("/UploadMultipleFiles")
//        public List<FileResponse> uploadMultipleFiles(MultipartFile[] files) {
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

