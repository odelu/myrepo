package com.realpage.demo.resource;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.realpage.demo.payload.UploadFileResponse;
import com.realpage.demo.service.FileStorageService;

@RestController
public class FileControllerResource {
	
	private static final Logger logger = LoggerFactory.getLogger(FileControllerResource.class);

	@Autowired
	private FileStorageService fileStorageService;

	@PostMapping("/uploadFile/{university}/{year}")
	public UploadFileResponse uploadFile(@RequestParam("file") MultipartFile file, @PathVariable("university") String university, @PathVariable("year") String year) {
		String fileName = fileStorageService.storeFile(file, university, year);
		
		return new UploadFileResponse(fileName, "Success",
                file.getContentType(), file.getSize());
	}
	
	@PostMapping("/uploadMultipleFiles/{university}/{year}")
    public List<UploadFileResponse> uploadMultipleFiles(@RequestParam("files") MultipartFile[] files, @PathVariable("university") String university, @PathVariable("year") String year) {
        return Arrays.asList(files)
                .stream()
                .map(file -> uploadFile(file, university, year))
                .collect(Collectors.toList());
    }
	
	@GetMapping("/downloadFile/{university}/{year}/{fileName:.+}")
    public ResponseEntity<Resource> downloadFile(@PathVariable("university") String university, @PathVariable("year") String year, @PathVariable String fileName, HttpServletRequest request) {
        // Load file as Resource
        Resource resource = fileStorageService.loadFileAsResource(university, year, fileName);

        // Try to determine file's content type
        String contentType = null;
        try {
            contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
        } catch (IOException ex) {
            logger.info("Could not determine file type.");
        }

        // Fallback to the default content type if type could not be determined
        if(contentType == null) {
            contentType = "application/octet-stream";
        }

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
    }
	
}
