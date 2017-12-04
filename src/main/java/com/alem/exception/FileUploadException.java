package com.alem.exception;

import java.util.Map;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.multipart.MultipartException;

@ControllerAdvice
public class FileUploadException {
	// StandardServletMultipartResolver
	@ExceptionHandler(MultipartException.class)
	public String handleError1(MultipartException e, Map<String, Object> model) {

		model.put("message", e.getCause().getMessage());
		return "index";

	}

	// CommonsMultipartResolver
	@ExceptionHandler(MaxUploadSizeExceededException.class)
	public String handleError2(MaxUploadSizeExceededException e, Map<String, Object> model) {

		model.put("message", e.getCause().getMessage());
		return "index";

	}
}