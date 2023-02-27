package com.spartanHardware.service;

import com.spartanHardware.model.dto.request.ProductRequestDto;
import com.spartanHardware.model.dto.request.ProductReviewRequestDto;
import com.spartanHardware.model.dto.response.ProductCategoryResponseDto;
import com.spartanHardware.model.dto.response.ProductResponseDto;
import com.spartanHardware.model.dto.response.ProductReviewResponseDto;
import com.spartanHardware.model.dto.response.ProductSubCategoryResponseDto;
import com.spartanHardware.model.entity.ParentCategory;
import com.spartanHardware.model.entity.Product;
import com.spartanHardware.model.entity.SubCategory;
import com.spartanHardware.model.entity.User;
import org.springframework.data.domain.Page;

import java.util.List;

public interface IProductService {

    ProductResponseDto createProduct(ProductRequestDto productRequestDto);

    ProductResponseDto updateProduct(Long id, ProductRequestDto productRequestDto);

    void deleteProduct(Long id);

    ProductResponseDto getProductDetails(Long id);

    ProductReviewResponseDto reviewProduct(Long id, User loggedUser, ProductReviewRequestDto reviewRequestDto);

    Page<ProductReviewResponseDto> getAllReviewsByProductId(Long id, int page);

    List<ProductCategoryResponseDto> getAllProductCategories();

    List<ProductSubCategoryResponseDto> getAllProductSubCategories();

    Product getProductById(Long id);

    ParentCategory getCategoryByNameOrCreateNewOne(String category);

    SubCategory getSubCategoryByNameOrCreateNewOne(String subCategory);

    Page<ProductResponseDto> getAllProducts(int page);
}
