package com.bridgelabz.utility;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
@Component
public class FileManager {
	
//	public final String UDIR = "C:\\MYNewProject\\VotingApplication\\src\\main\\resources\\static\\images";
	public final String UDIR = new ClassPathResource("static/images/").getFile().getAbsolutePath();
	
	public FileManager() throws IOException{
		
	}
	
	public boolean fileUpload(MultipartFile file) {
		boolean found=false;
		try {
			Files.copy(file.getInputStream(),Paths.get(UDIR+File.separator+file.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
			 found=true;
		}
		catch (Exception e) {
			System.out.println(e);
		}
		return found;
	}
}
