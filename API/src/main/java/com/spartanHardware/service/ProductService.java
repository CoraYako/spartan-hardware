package com.spartanHardware.service;

import com.spartanHardware.model.dto.request.ProductRequestDto;
import com.spartanHardware.model.dto.response.ProductResponseDto;
import com.spartanHardware.model.entity.ParentCategory;
import com.spartanHardware.model.entity.Product;
import com.spartanHardware.model.entity.SubCategory;

public interface ProductService {

    ProductResponseDto createProduct(ProductRequestDto productRequestDto);

    void deleteProduct(Long id);

    ProductResponseDto getProductDetails(Long id);

    Product getProductById(Long id);

    ParentCategory getCategoryByNameOrCreateNewOne(String category);

    SubCategory getSubCategoryByNameOrCreateNewOne(String subCategory);
}
