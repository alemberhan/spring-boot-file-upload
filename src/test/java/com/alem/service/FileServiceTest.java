package com.alem.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.fileUpload;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest
public class FileServiceTest {

	@Autowired
	private MockMvc mvc;

	@Autowired
	private FileService fileService;

	@Rule
	public TemporaryFolder folder = new TemporaryFolder();

	@Test
	public void testUploadFile() throws Exception {

		MockMultipartFile file = new MockMultipartFile("file", "hello.txt", MediaType.TEXT_PLAIN_VALUE,
				"Hello, World!".getBytes());
		mvc.perform(fileUpload("/upload").file(file)).andExpect(status().isOk());

	}

	@Test
	public void uploadPermitted() {

		boolean value = fileService.uploadFile(
				new MockMultipartFile("foo", "foo.txt", MediaType.TEXT_PLAIN_VALUE, "Hello World".getBytes()));
		assertThat(value);

	}

}
