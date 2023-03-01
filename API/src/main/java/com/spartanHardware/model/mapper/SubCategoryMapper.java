package com.spartanHardware.model.mapper;

import com.spartanHardware.model.dto.response.ProductSubCategoryResponseDto;
import com.spartanHardware.model.entity.SubCategory;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class SubCategoryMapper implements Function<SubCategory, ProductSubCategoryResponseDto> {

    @Override
    public ProductSubCategoryResponseDto apply(SubCategory subCategory) {
        ProductSubCategoryResponseDto subCategoryResponseDto = new ProductSubCategoryResponseDto();

        subCategoryResponseDto.setId(subCategory.getId());
        subCategoryResponseDto.setSubCategory(subCategory.getSubCategory());

        return subCategoryResponseDto;
    }
}
