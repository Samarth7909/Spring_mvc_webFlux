package com.apress.prospringmvc.bookstore.service;

import com.apress.prospringmvc.bookstore.util.WebFile;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.util.stream.Stream;

/**
 * on 23/05/2025
 */
public interface FileStorageService {
	void store(MultipartFile file);

	Stream<Path> loadAll();

	Resource loadAsResource(String filename);

	void deleteAll();

}
