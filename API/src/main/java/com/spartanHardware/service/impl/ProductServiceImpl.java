package com.spartanHardware.service.impl;

import com.spartanHardware.model.dto.request.ProductFilterRequest;
import com.spartanHardware.model.dto.request.ProductRequestDto;
import com.spartanHardware.model.dto.request.ProductReviewRequestDto;
import com.spartanHardware.model.dto.response.ProductCategoryResponseDto;
import com.spartanHardware.model.dto.response.ProductResponseDto;
import com.spartanHardware.model.dto.response.ProductReviewResponseDto;
import com.spartanHardware.model.dto.response.ProductSubCategoryResponseDto;
import com.spartanHardware.model.entity.*;
import com.spartanHardware.model.mapper.ParentCategoryMapper;
import com.spartanHardware.model.mapper.ProductMapper;
import com.spartanHardware.model.mapper.SubCategoryMapper;
import com.spartanHardware.repository.ImageRepository;
import com.spartanHardware.repository.ParentCategoryRepository;
import com.spartanHardware.repository.ProductRepository;
import com.spartanHardware.repository.SubCategoryRepository;
import com.spartanHardware.repository.specification.ProductSpecification;
import com.spartanHardware.service.IProductService;
import com.spartanHardware.service.IReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.NoSuchElementException;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static java.time.LocalDateTime.now;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements IProductService {

    // TODO: 20/2/2023 move this constant into utility class
    private static final int PAGE_SIZE = 10;

    private final ProductRepository productRepository;
    private final ParentCategoryRepository categoryRepository;
    private final SubCategoryRepository subCategoryRepository;
    private final ImageRepository imageRepository;
    private final ProductSpecification productSpecification;
    private final ProductMapper productMapper;
    private final ParentCategoryMapper categoryMapper;
    private final SubCategoryMapper subCategoryMapper;
    private final IReviewService reviewService;
    private final MessageSource message;

    @Override
    @Transactional
    public ProductResponseDto createProduct(ProductRequestDto productRequestDto) {
        Product product = productMapper.toEntity(productRequestDto);

        List<Image> images = new ArrayList<>();
        if (!productRequestDto.getImages().isEmpty()) {
            productRequestDto.getImages().forEach(imageUrl ->
                images.add(new Image(imageUrl, product))
            );
        }
        product.setProductImages(images);

        ParentCategory category = getCategoryByNameOrCreateNewOne(productRequestDto.getCategory());
        SubCategory subCategory = getSubCategoryByNameOrCreateNewOne(productRequestDto.getSubCategory());

        category.getProducts().add(product);
        category.getSubCategories().add(subCategory);

        subCategory.getProducts().add(product);
        subCategory.setParentCategory(category);

        product.setParentCategory(category);
        product.setSubCategory(subCategory);

        Product productSaved = productRepository.save(product);
        imageRepository.saveAll(images);

        return productMapper.apply(productSaved);
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
        return productRepository.findById(id).orElseThrow(() -> new NullPointerException(
                message.getMessage("entity.notFound", new String[] {"Product", "id", id.toString()}, Locale.US)
        ));
    }

    @Override
    public ParentCategory getCategoryByNameOrCreateNewOne(String category) {
        return categoryRepository.findByCategory(category)
                .orElseGet(() -> new ParentCategory(category));
    }

    @Override
    public SubCategory getSubCategoryByNameOrCreateNewOne(String subCategory) {
        return subCategoryRepository.findBySubCategory(subCategory)
                .orElseGet(() -> new SubCategory(subCategory));
    }

    @Override
    public Page<ProductResponseDto> getAllProducts(int page) {
        Pageable pageable = PageRequest.of(page, PAGE_SIZE);
        pageable.next().getPageNumber();
        return productRepository.findAll(pageable).map(productMapper);
    }

    @Override
    public Page<ProductResponseDto> getProductsFilteredByName(String query, int page) {
        Pageable pageable = PageRequest.of(page, PAGE_SIZE);
        pageable.next().getPageNumber();
        Page<Product> products = productRepository.findAllByName(query, pageable);
        if (products.isEmpty()) {
            throw new NoSuchElementException(
                    message.getMessage("product.categoryOrName", null, Locale.US)
            );
        }
        return products.map(productMapper);
    }

    @Override
    public Page<ProductResponseDto> getProductsFilteredByCategories(String category, String subCategory, int page) {
        Pageable pageable = PageRequest.of(page, PAGE_SIZE);
        pageable.next().getPageNumber();
        Page<Product> products = productRepository.findAll(productSpecification.getByFilters(
                new ProductFilterRequest(category, subCategory)), pageable);
        if (products.isEmpty()) {
            throw new NoSuchElementException(
                    message.getMessage("product.categoryOrName", null, Locale.US)
            );
        }
        return products.map(productMapper);
    }

    @Override
    public List<ProductResponseDto> getAllProductsRecommended() {
        return productRepository.finAllProductsIfRecommended(TRUE).stream().map(productMapper).toList();
    }
}
