package com.example.daedongv3_5.infra.service;

import com.example.daedongv3_5.infra.exception.DeleteImageFailedException;
import com.example.daedongv3_5.infra.exception.ImageNotFoundException;
import com.example.daedongv3_5.infra.exception.InvalidImageException;
import com.example.daedongv3_5.infra.s3.S3Properties;
import com.example.daedongv3_5.infra.type.FolderType;
import io.awspring.cloud.s3.ObjectMetadata;
import io.awspring.cloud.s3.S3Operations;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.Set;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class S3Service {

    private final Set<String> IMAGE_EXTENSIONS = Set.of(".jpg", ".jpeg", ".png", ".gif");

    private final S3Properties s3Properties;
    private final S3Operations s3Operations;

    public void uploadImage(MultipartFile file, FolderType type) throws IOException {
        String fileName = file.getOriginalFilename();
        validate(fileName);

        String key = generateKey(fileName, type);

        s3Operations.upload(
            s3Properties.bucket(),
            key,
            file.getInputStream(),
            ObjectMetadata.builder()
                .contentType(file.getContentType())
                .build());
    }

    public void deleteImage(String imageUrl) {
        String key = getKey(imageUrl);
        s3Operations.deleteObject(s3Properties.bucket(), key);
    }

    private void validate(String fileName) {
        if (fileName == null || fileName.isEmpty()) {
            throw ImageNotFoundException.EXCEPTION;
        }

        String extension = getExtension(fileName);
        if (!IMAGE_EXTENSIONS.contains(extension)) {
            throw InvalidImageException.EXCEPTION;
        }
    }

    private String generateKey(String originalFilename, FolderType folderType) {
        String path;
        switch (folderType) {
            case PROFILE_IMAGES -> path = s3Properties.profileImages();
            case CLUB_IMAGES -> path = s3Properties.clubImages();
            case CLUB_LOGO_IMAGES -> path = s3Properties.clubLogoImages();
            default -> throw InvalidImageException.EXCEPTION;
        }

        String extension = getExtension(originalFilename);
        return path + "/" + UUID.randomUUID() + extension;
    }

    private String getExtension(String fileName) {
        return fileName.substring(fileName.lastIndexOf(".")).toLowerCase();
    }

    private String getKey(String imageUrl) {
        try {
            URL url = new URI(imageUrl).toURL();
            String decodedKey = URLDecoder.decode(url.getPath(), StandardCharsets.UTF_8);

            if (decodedKey.startsWith("/")) {
                return decodedKey.substring(1);
            }
            return decodedKey;
        } catch (Exception e) {
            throw DeleteImageFailedException.EXCEPTION;
        }
    }

}