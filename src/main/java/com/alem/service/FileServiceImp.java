package com.alem.service;

import java.io.IOException;
import java.sql.Timestamp;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.alem.model.File;
import com.alem.repository.FileRepository;

@Service
@PropertySource(value = { "classpath:application.properties" })
public class FileServiceImp implements FileService {

	@Autowired
	private FileRepository fileRepository;

	// path to folder where uploaded file saved
	@Value("${file-path}")
	private String folder;

	@Override
	@Transactional
	public boolean uploadFile(MultipartFile multFile) {

		try {
			// get the file and save the meta-data in the database and store the
			// content on a file system
			String fileName = FilenameUtils.getName(multFile.getOriginalFilename());

			// check if the folder exists, if not create
			if (!new java.io.File(folder).exists()) {
				new java.io.File(folder).mkdir();
			}

			java.io.File dir = new java.io.File(folder + fileName);
			multFile.transferTo(dir);
			fileRepository.save(createFile(fileName));
			return true;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public File createFile(String fileName) {
		Timestamp localTimestamp = new Timestamp(System.currentTimeMillis());
		File fileObject = fileRepository.findByName(fileName);
		if (fileObject == null) {
			fileObject = new File();
			fileObject.setName(fileName);
			fileObject.setCreatedDate(localTimestamp);
			fileObject.setUpdatedDate(localTimestamp);
		} else {
			fileObject.setUpdatedDate(localTimestamp);
		}

		return fileObject;
	}

}
