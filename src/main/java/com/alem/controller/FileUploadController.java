package com.alem.controller;

import java.util.Map;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.alem.service.FileService;

@Controller
public class FileUploadController {

	@Autowired
	FileService fileService;

	@RequestMapping("/")
	public String index() {
		return "index";
	}

	@RequestMapping("/upload")
	public String uploadFile(@RequestParam("file") MultipartFile file, Map<String, Object> model) {

		if (file.isEmpty()) {
			model.put("message", "Please select a file to upload");
		} else if (fileService.uploadFile(file)) {
			model.put("message", "You Have sucessfully uploaded " + FilenameUtils.getName(file.getOriginalFilename()));
		} else {
			model.put("message", "SERVER ERROR!!! Please See the log.");
		}
		return "index";
	}
}
