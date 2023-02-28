package com.spartanHardware.service.impl;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.spartanHardware.service.IAWSS3Service;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Objects;

@Service
@Slf4j
@RequiredArgsConstructor
public class AWSS3ServiceImpl implements IAWSS3Service {

    private final AmazonS3 amazonS3;

    @Value("${aws.s3.bucket}")
    private String bucket;

    @Override
    public void uploadFile(MultipartFile file) {
        File mainFile = new File(Objects.requireNonNull(file.getOriginalFilename()));

        try (FileOutputStream stream = new FileOutputStream(mainFile)) {
            stream.write(file.getBytes());

            String newFileName = System.currentTimeMillis() + mainFile.getName();
            log.info("Uploading file to S3 with name " + newFileName);

            PutObjectRequest request = new PutObjectRequest(bucket, newFileName, mainFile);
            amazonS3.putObject(request);
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        }
    }
}
