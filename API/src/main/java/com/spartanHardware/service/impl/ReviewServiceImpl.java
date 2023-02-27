package com.spartanHardware.service.impl;

import com.spartanHardware.model.dto.request.ProductReviewRequestDto;
import com.spartanHardware.model.dto.response.ProductReviewResponseDto;
import com.spartanHardware.model.entity.Product;
import com.spartanHardware.model.entity.Review;
import com.spartanHardware.model.entity.User;
import com.spartanHardware.model.mapper.ReviewMapper;
import com.spartanHardware.repository.ReviewRepository;
import com.spartanHardware.service.IReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ReviewServiceImpl implements IReviewService {

    // TODO: 25/2/2023 move this constant into utility class
    private static final int PAGE_SIZE = 10;

    private final ReviewRepository reviewRepository;
    private final ReviewMapper reviewMapper;

    @Override
    public ProductReviewResponseDto createReview(Product product, User user, ProductReviewRequestDto reviewRequestDto) {
        Review review = reviewMapper.toEntity(reviewRequestDto);
        review.setUser(user);
        review.setProduct(product);
        return reviewMapper.apply(reviewRepository.save(review));
    }

    @Override
    public Page<ProductReviewResponseDto> getAllReviewsByProductId(Long productId, int page) {
        Pageable pageable = PageRequest.of(page, PAGE_SIZE);
        pageable.next().getPageNumber();
        return reviewRepository.findReviewByProductId(productId, pageable).map(reviewMapper);
    }

    @Override
    public Page<ProductReviewResponseDto> getAllReviewsByUserId(Long userId, int page) {
        Pageable pageable = PageRequest.of(page, PAGE_SIZE);
        pageable.next().getPageNumber();
        return reviewRepository.findReviewByUserId(userId, pageable).map(reviewMapper);
    }
}
