package com.alem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alem.model.File;

public interface FileRepository extends JpaRepository<File, Long> {
	File findByName(String name);
}
