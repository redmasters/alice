package io.red.alice.services;

import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;

public interface StorageService {
    Path store(MultipartFile file);
    Path load(String fileName);
    void init();
    void deleteAll();

}
