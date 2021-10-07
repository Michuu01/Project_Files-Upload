package com.home.Recruitment_Project.file;

import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;

//@Entity
//
//public class File {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long fileid;
//    private String fileName;
//    private String fileType;
//    @Lob
//    private byte[] fileData;
//
//    public Long getFileid() {
//        return fileid;
//    }
//
//    public void setFileid(Long fileid) {
//        this.fileid = fileid;
//    }
//
//    public String getFileName() {
//        return fileName;
//    }
//
//    public void setFileName(String fileName) {
//        this.fileName = fileName;
//    }
//
//    public String getFileType() {
//        return fileType;
//    }
//
//    public void setFileType(String fileType) {
//        this.fileType = fileType;
//    }
//
//    public byte[] getFileData() {
//        return fileData;
//    }
//
//    public void setFileData(byte[] fileData) {
//        this.fileData = fileData;
//    }
//
//    public File() {
//    }
//
//    public File(Long fileid, String fileName, String fileType, byte[] fileData) {
//        this.fileid = fileid;
//        this.fileName = fileName;
//        this.fileType = fileType;
//        this.fileData = fileData;
//    }
//}
