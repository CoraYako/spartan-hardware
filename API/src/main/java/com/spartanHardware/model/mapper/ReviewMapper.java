package com.spartanHardware.model.mapper;

import com.spartanHardware.model.dto.request.ProductReviewRequestDto;
import com.spartanHardware.model.dto.response.ProductReviewResponseDto;
import com.spartanHardware.model.entity.Review;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class ReviewMapper implements Function<Review, ProductReviewResponseDto> {

    public Review toEntity(ProductReviewRequestDto reviewRequestDto) {
        Review review = new Review();

        review.setRate(reviewRequestDto.getRate());
        review.setComment(reviewRequestDto.getComment());

        return review;
    }

    @Override
    public ProductReviewResponseDto apply(Review review) {
        ProductReviewResponseDto reviewResponseDto = new ProductReviewResponseDto();

        reviewResponseDto.setId(review.getId());
        reviewResponseDto.setUser(review.getUser().getFirstName() + ' ' + review.getUser().getLastName());
        reviewResponseDto.setProduct(review.getProduct().getName());
        reviewResponseDto.setRate(review.getRate());
        reviewResponseDto.setComment(review.getComment());
        reviewResponseDto.setCreationDate(review.getCreationDate());

        return reviewResponseDto;
    }
}
