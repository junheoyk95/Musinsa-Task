package com.example.musinsa.common;

import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

@Component
public class ImageUploader {

    private static final String UPLOAD_DIRECTORY = System.getProperty("user.dir") + "/src/main/resources/static/image/fileDirectory/";

    private final ResourceLoader resourceLoader;

    public ImageUploader(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    public String uploadImage(MultipartFile file) throws IOException {
        String originalFilename = file.getOriginalFilename();
        String extension = StringUtils.getFilenameExtension(originalFilename);
        String filename = generateUniqueFilename(extension);

        Path uploadPath = Path.of(UPLOAD_DIRECTORY);
        Files.createDirectories(uploadPath);

        Path filePath = uploadPath.resolve(filename);
        Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

        return filename;
    }

    public void deleteImage(String filename) throws IOException {
        Path imagePath = Path.of(UPLOAD_DIRECTORY, filename);
        Files.deleteIfExists(imagePath);
    }

    private String generateUniqueFilename(String extension) {
        String uniqueFilename = UUID.randomUUID().toString();
        return uniqueFilename + "." + extension;
    }
}
