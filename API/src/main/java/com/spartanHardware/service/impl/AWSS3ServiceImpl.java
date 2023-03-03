package com.spartanHardware.service.impl;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.PutObjectResult;
import com.spartanHardware.model.dto.response.ImageURLResponseDto;
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
    private String BUCKET;

    @Override
    public ImageURLResponseDto uploadFile(MultipartFile file) {
        File mainFile = new File(Objects.requireNonNull(file.getOriginalFilename()));

        try (FileOutputStream stream = new FileOutputStream(mainFile)) {
            stream.write(file.getBytes());

            String fileName = System.currentTimeMillis() + mainFile.getName();
            log.info("File will be upload to S3 with name " + fileName);

            PutObjectRequest request = new PutObjectRequest(BUCKET, fileName, mainFile)
                    .withCannedAcl(CannedAccessControlList.PublicRead);
            PutObjectResult result = amazonS3.putObject(request);
            log.info("AWS S3 result: " + result.getETag());
            return ImageURLResponseDto.builder()
                    .url(String.valueOf(amazonS3.getUrl(BUCKET, fileName)))
                    .build();
        } catch (IOException e) {
            log.error(e.getMessage(), e);
            return ImageURLResponseDto.builder()
                    .url(null)
                    .build();
        }
    }
}
