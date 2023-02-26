package com.spartanHardware.service.impl;

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
import com.spartanHardware.model.mapper.ParentCategoryMapper;
import com.spartanHardware.model.mapper.ProductMapper;
import com.spartanHardware.model.mapper.SubCategoryMapper;
import com.spartanHardware.repository.ParentCategoryRepository;
import com.spartanHardware.repository.ProductRepository;
import com.spartanHardware.repository.SubCategoryRepository;
import com.spartanHardware.service.IProductService;
import com.spartanHardware.service.IReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.lang.Boolean.FALSE;
import static java.time.LocalDateTime.now;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements IProductService {

    // TODO: 20/2/2023 move this constant into utility class
    private static final int PAGE_SIZE = 10;

    private final ProductRepository productRepository;
    private final ParentCategoryRepository categoryRepository;
    private final SubCategoryRepository subCategoryRepository;
    private final ProductMapper productMapper;
    private final ParentCategoryMapper categoryMapper;
    private final SubCategoryMapper subCategoryMapper;
    private final IReviewService reviewService;

    @Override
    public ProductResponseDto createProduct(ProductRequestDto productRequestDto) {
        Product product = productMapper.toEntity(productRequestDto);

        ParentCategory category = getCategoryByNameOrCreateNewOne(productRequestDto.getCategory());
        SubCategory subCategory = getSubCategoryByNameOrCreateNewOne(productRequestDto.getSubCategory());

        subCategory.getProducts().add(product);
        subCategory.setParentCategory(category);
        subCategoryRepository.save(subCategory);

        category.getProducts().add(product);
        category.getSubCategories().add(subCategory);
        categoryRepository.save(category);

        product.setParentCategory(category);
        product.setSubCategory(subCategory);

        return productMapper.apply(productRepository.save(product));
    }

    @Override
    public ProductResponseDto updateProduct(Long id, ProductRequestDto productRequestDto) {
        Product productFound = getProductById(id);
        ParentCategory category;
        SubCategory subCategory;

        productFound = productMapper.refreshValues(productFound, productRequestDto);

        if (productRequestDto.getCategory() != null && !productRequestDto.getCategory().trim().isEmpty()) {
            category = getCategoryByNameOrCreateNewOne(productRequestDto.getCategory());
            productFound.setParentCategory(category);
        }
        if (productRequestDto.getSubCategory() != null && !productRequestDto.getSubCategory().trim().isEmpty()) {
            subCategory = getSubCategoryByNameOrCreateNewOne(productRequestDto.getSubCategory());
            productFound.setSubCategory(subCategory);
        }

        productFound.setUpdateDate(now());
        return productMapper.apply(productRepository.save(productFound));
    }

    @Override
    public void deleteProduct(Long id) {
        Product product = getProductById(id);
        product.setAvailable(FALSE);
        productRepository.save(product);
    }

    @Override
    public ProductResponseDto getProductDetails(Long id) {
        return productMapper.apply(getProductById(id));
    }

    @Override
    public ProductReviewResponseDto reviewProduct(Long id, User loggedUser, ProductReviewRequestDto reviewRequestDto) {
        Product productToReview = getProductById(id);
        return reviewService.createReview(
                productToReview,
                loggedUser,
                reviewRequestDto
        );
    }

    @Override
    public Page<ProductReviewResponseDto> getAllReviewsByProductId(Long id, int page) {
        return reviewService.getAllReviewsByProductId(id, page);
    }

    @Override
    public List<ProductCategoryResponseDto> getAllProductCategories() {
        return categoryRepository.findAll().stream().map(categoryMapper).toList();
    }

    @Override
    public List<ProductSubCategoryResponseDto> getAllProductSubCategories() {
        return subCategoryRepository.findAll().stream().map(subCategoryMapper).toList();
    }

    @Override
    public Product getProductById(Long id) {
        // TODO: 18/2/2023 change message to a properties value
        return productRepository.findById(id).orElseThrow(() -> new NullPointerException("Product not found"));
    }

    @Override
    public ParentCategory getCategoryByNameOrCreateNewOne(String category) {
        return categoryRepository.findByCategory(category)
                .orElseGet(() -> categoryRepository.save(new ParentCategory(category)));
    }

    @Override
    public SubCategory getSubCategoryByNameOrCreateNewOne(String subCategory) {
        return subCategoryRepository.findBySubCategory(subCategory)
                .orElseGet(() -> subCategoryRepository.save(new SubCategory(subCategory)));
    }

    @Override
    public Page<ProductResponseDto> getAllProducts(int page) {
        Pageable pageable = PageRequest.of(page, PAGE_SIZE);
        pageable.next().getPageNumber();
        return productRepository.findAll(pageable).map(productMapper);
    }
}
