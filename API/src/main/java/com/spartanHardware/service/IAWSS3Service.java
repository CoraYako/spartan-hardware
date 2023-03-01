package com.spartanHardware.service;

import com.spartanHardware.model.dto.response.ImageURLResponseDto;
import org.springframework.web.multipart.MultipartFile;

public interface IAWSS3Service {

    ImageURLResponseDto uploadFile(MultipartFile file);
}