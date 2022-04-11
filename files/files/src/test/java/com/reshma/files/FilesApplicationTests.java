package com.reshma.files;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.reshma.files.entities.Image;
import com.reshma.files.repo.ImageRepository;

@SpringBootTest
class FilesApplicationTests {
	
	@Autowired
	ImageRepository repository;
	
	
	@Test
	void testSaveFile() throws IOException {
		Image image = new Image();
		image.setName("maternity.jpg");
		File file = new File("C://Users//user//Pictures//Saved Pictures/maternity.JPG"); //path +filename
		byte fileContent [] =new byte[(int)file.length()];
		FileInputStream fileInputStream = new FileInputStream(file);
		fileInputStream.read(fileContent);
		image.setData(fileContent);
		repository.save(image);
		fileInputStream.close();
	}
	
	@Test
	void testRetrieveFile() throws IOException {
		Image image = repository.findById(81).get();
		File file = new File("C://Users//user//Pictures//Saved Pictures/mine/"+image.getName());
		FileOutputStream fileOutput=null;
		try {
			fileOutput=new FileOutputStream(file);
			fileOutput.write(image.getData());
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}
		fileOutput.close();	
		
	}
	
	

}
