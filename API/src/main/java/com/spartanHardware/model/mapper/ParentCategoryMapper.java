package com.spartanHardware.model.mapper;

import com.spartanHardware.model.dto.response.ProductCategoryResponseDto;
import com.spartanHardware.model.entity.ParentCategory;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class ParentCategoryMapper implements Function<ParentCategory, ProductCategoryResponseDto> {

    @Override
    public ProductCategoryResponseDto apply(ParentCategory category) {
        ProductCategoryResponseDto categoryResponseDto = new ProductCategoryResponseDto();

        categoryResponseDto.setId(category.getId());
        categoryResponseDto.setCategory(category.getCategory());

        return categoryResponseDto;
    }
}
