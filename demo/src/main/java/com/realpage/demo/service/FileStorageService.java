package com.realpage.demo.service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.realpage.demo.exception.FileStorageException;
import com.realpage.demo.exception.MyFileNotFoundException;
import com.realpage.demo.pojo.FileStorageProperties;

@Service
public class FileStorageService {

	private String fileStoragePathStructure;
	
	@Autowired
    public FileStorageService(FileStorageProperties fileStorageProperties) {
        this.fileStoragePathStructure = fileStorageProperties.getUploadDir()+"/%s/%s";
    }

    public String storeFile(MultipartFile file, String university, String year) {
    	
//    	int currentYear = Calendar.getInstance().get(Calendar.YEAR);
    	Path fileStorageLocation = Paths.get(String.format(fileStoragePathStructure, university, year)).toAbsolutePath().normalize();
    	try {
            Files.createDirectories(fileStorageLocation);
        } catch (Exception ex) {
            throw new FileStorageException("Could not create the directory where the uploaded files will be stored.", ex);
        }
        // Normalize file name
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

        try {
            // Check if the file's name contains invalid characters
            if(fileName.contains("..")) {
                throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
            }

            // Copy file to the target location (Replacing existing file with the same name)
            Path targetLocation = fileStorageLocation.resolve(fileName);
            Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);

            return fileName;
        } catch (IOException ex) {
            throw new FileStorageException("Could not store file " + fileName + ". Please try again!", ex);
        }
    }
    
    public Resource loadFileAsResource(String university, String year, String fileName) {
        try {
        	Path fileStorageLocation = Paths.get(String.format(fileStoragePathStructure, university, year)).toAbsolutePath().normalize();
            Path filePath = fileStorageLocation.resolve(fileName).normalize();
            Resource resource = new UrlResource(filePath.toUri());
            if(resource.exists()) {
                return resource;
            } else {
                throw new MyFileNotFoundException("File not found " + fileName);
            }
        } catch (MalformedURLException ex) {
            throw new MyFileNotFoundException("File not found " + fileName, ex);
        }
    }
}
