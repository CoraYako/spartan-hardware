package com.spartanHardware.service;

import com.spartanHardware.model.dto.request.ProductRequestDto;
import com.spartanHardware.model.dto.response.ProductResponseDto;
import com.spartanHardware.model.entity.ParentCategory;
import com.spartanHardware.model.entity.Product;
import com.spartanHardware.model.entity.ProductAttribute;
import com.spartanHardware.model.entity.SubCategory;
import org.springframework.data.domain.Page;

public interface ProductService {

    ProductResponseDto createProduct(ProductRequestDto productRequestDto);

    ProductResponseDto updateProduct(Long id, ProductRequestDto productRequestDto);

    void deleteProduct(Long id);

    ProductResponseDto getProductDetails(Long id);

    Product getProductById(Long id);

    ProductAttribute getAttributeByAttributeNameAndProductId(String attribute, Long productId);

    ParentCategory getCategoryByNameOrCreateNewOne(String category);

    SubCategory getSubCategoryByNameOrCreateNewOne(String subCategory);

    Page<ProductResponseDto> getAllProducts(int page);
}
