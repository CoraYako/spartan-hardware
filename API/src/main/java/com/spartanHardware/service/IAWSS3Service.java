package com.spartanHardware.service;

import org.springframework.web.multipart.MultipartFile;

public interface IAWSS3Service {

    void uploadFile(MultipartFile file);
}