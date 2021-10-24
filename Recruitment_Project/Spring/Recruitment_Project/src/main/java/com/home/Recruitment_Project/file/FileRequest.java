package com.home.Recruitment_Project.file;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;


public class FileRequest {
    private String fileName;
    private String fileType;
    private String fileUri;
    private String deleteUri;
    private double size;
    LocalDate localDate = LocalDate.now(ZoneId.of("Europe/Paris"));

    public LocalDate getLocalDate() {
        return localDate;
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }

    public String getDeleteUri() {
        return deleteUri;
    }

    public void setDeleteUri(String deleteUri) {
        this.deleteUri = deleteUri;
    }

    public FileRequest(String fileName, String fileType, String fileUri, String deleteUri, double size, LocalDate localDate) {
        this.fileName = fileName;
        this.fileType = fileType;
        this.fileUri = fileUri;
        this.deleteUri = deleteUri;
        this.size = size;
        this.localDate = localDate;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public String getFileUri() {
        return fileUri;
    }

    public void setFileUri(String fileUri) {
        this.fileUri = fileUri;
    }

    public double getSize() {
        if (size < 11000) {
            size = 0.01;
        } else {

            size = size / 1048576;
            size *= 100;
            size = Math.round(size);
            size /= 100;

        }
        return size;
    }
    public void setSize(double size) {
        this.size = size;
    }
}
