package com.realpage.demo.payload;

import java.io.Serializable;

public class UploadFileResponse implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String fileName;
    private String uploadStatus;
    private String fileType;
    private long size;

    public UploadFileResponse(String fileName, String uploadStatus, String fileType, long size) {
        this.fileName = fileName;
        this.uploadStatus = uploadStatus;
        this.fileType = fileType;
        this.size = size;
    }

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getUploadStatus() {
		return uploadStatus;
	}

	public void setUploadStatus(String uploadStatus) {
		this.uploadStatus = uploadStatus;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public long getSize() {
		return size;
	}

	public void setSize(long size) {
		this.size = size;
	}
  
    	
}
