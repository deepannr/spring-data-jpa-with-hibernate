package com.spring.boot.jpa.saveAndRetrieveFiles;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/fileSaveAndRetrieve")
class ImageApi {

	@Autowired
	private ImageRepository repository;

	@PostMapping("/add")
	public void addFile(@RequestParam("name") String fileName, @RequestParam("image") MultipartFile file)
			throws IOException {
		byte[] fileContent = new byte[(int) file.getSize()];

		InputStream inputStream = file.getInputStream();
		inputStream.read(fileContent);

		Image image = new Image();
		image.setName(fileName);
		image.setData(fileContent);

		repository.save(image);

		inputStream.close();
	}

	@GetMapping("/find/{id}")
	public String findFile(@PathVariable int id) throws FileNotFoundException, IOException {
		Image image = repository.findById(id).get();

		String downloadedFile = "C:/Yezdi/StudyProjects/SpringBootWithMicroServices/Code/spring-data-jpa-with-hibernate/src/main/resources/downloads/" + image.getName();
		File file = new File(downloadedFile);
		FileOutputStream fos = new FileOutputStream(file);
		fos.write(image.getData());
		
		fos.close();
		return downloadedFile; 
	}
}
