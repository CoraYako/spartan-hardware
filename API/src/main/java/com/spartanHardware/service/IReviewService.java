package com.spartanHardware.service;

import com.spartanHardware.model.dto.request.ProductReviewRequestDto;
import com.spartanHardware.model.dto.response.ProductReviewResponseDto;
import com.spartanHardware.model.entity.Product;
import com.spartanHardware.model.entity.Review;
import com.spartanHardware.model.entity.User;
import org.springframework.data.domain.Page;

import java.util.List;

public interface IReviewService {

    ProductReviewResponseDto createReview(Product product, User user, ProductReviewRequestDto reviewRequestDto);

    Page<ProductReviewResponseDto> getAllReviewsByProductId(Long productId, int page);

    Page<ProductReviewResponseDto> getAllReviewsByUserId(Long userId, int page);
}
