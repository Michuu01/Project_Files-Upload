package com.home.Recruitment_Project.file;


import java.text.DateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class FileRequest {
    private String fileName;
    private String fileType;
    private String fileUri;
    private long size;
    LocalDate localDate = LocalDate.now(ZoneId.of("Europe/Paris"));

    public LocalDate getLocalDate() {
        return localDate;
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }

    public FileRequest(String name, String fileName, String fileType, String fileUri, long size, LocalDate localDate) {
        this.fileName = fileName;
        this.fileType = fileType;
        this.fileUri = fileUri;
        this.size = size;
        this.localDate = localDate;
    }

    public FileRequest(String fileName, String fileType, String fileUri, long size) {
        this.fileName = fileName;
        this.fileType = fileType;
        this.fileUri = fileUri;
        this.size = size;
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

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }
}
