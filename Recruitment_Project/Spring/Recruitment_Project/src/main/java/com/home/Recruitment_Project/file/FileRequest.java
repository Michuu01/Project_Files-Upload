package com.home.Recruitment_Project.file;


public class FileRequest {
    private String fileName;
    private String fileType;
    private String fileUri;
    private long size;

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
