package com.api.book.bootrestbook.helper;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUploadHelper {
	
	public final String Upload_Dir="E:\\SpringBoot\\bootrestbook\\src\\main\\resources\\static\\image";
	
	public boolean uploadFile(MultipartFile multipartFile) {
		boolean f = false;
		try {
//			//read file data
//			InputStream inputStream = multipartFile.getInputStream();
//			byte data[] = new byte[inputStream.available()];
//			inputStream.read(data);
//			
//			//write data
//			FileOutputStream fos = new FileOutputStream(Upload_Dir+"\\"+multipartFile.getOriginalFilename());
//			fos.write(data);
			
			Files.copy(multipartFile.getInputStream(), Paths.get(Upload_Dir+File.separator+multipartFile.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
//			fos.flush();
//			fos.close();
//			inputStream.close();
			f=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}
}
