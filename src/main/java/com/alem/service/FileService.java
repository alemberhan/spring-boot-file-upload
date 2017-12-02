package com.alem.service;

import org.springframework.web.multipart.MultipartFile;

import com.alem.model.File;

public interface FileService {
	public boolean uploadFile(MultipartFile file);

	public File createFile(String fileName);

}
