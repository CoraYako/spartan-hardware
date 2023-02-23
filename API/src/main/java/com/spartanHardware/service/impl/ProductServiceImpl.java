package com.spartanHardware.service.impl;

import com.spartanHardware.model.dto.request.ProductRequestDto;
import com.spartanHardware.model.dto.response.ProductResponseDto;
import com.spartanHardware.model.entity.ParentCategory;
import com.spartanHardware.model.entity.Product;
import com.spartanHardware.model.entity.ProductAttribute;
import com.spartanHardware.model.entity.SubCategory;
import com.spartanHardware.model.mapper.ProductMapper;
import com.spartanHardware.repository.ParentCategoryRepository;
import com.spartanHardware.repository.ProductAttributeRepository;
import com.spartanHardware.repository.ProductRepository;
import com.spartanHardware.repository.SubCategoryRepository;
import com.spartanHardware.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Boolean.FALSE;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    // TODO: 20/2/2023 move this constant to a utility class
    private static final int PAGE_SIZE = 10;

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
    private final ProductAttributeRepository productAttributeRepository;
    private final ParentCategoryRepository categoryRepository;
    private final SubCategoryRepository subCategoryRepository;

    @Override
    public ProductResponseDto createProduct(ProductRequestDto productRequestDto) {
        Product product = productMapper.toEntity(productRequestDto);
        List<ProductAttribute> attributes = new ArrayList<>();

        ParentCategory category = getCategoryByNameOrCreateNewOne(productRequestDto.getCategory());
        SubCategory subCategory = getSubCategoryByNameOrCreateNewOne(productRequestDto.getSubCategory());

        productRequestDto.getAttributeAndValueMap().forEach((attribute, value) ->
                attributes.add(new ProductAttribute(attribute, value))
        );

        subCategory.getProducts().add(product);
        subCategory.setParentCategory(category);
        subCategoryRepository.save(subCategory);

        category.getProducts().add(product);
        category.getSubCategories().add(subCategory);
        categoryRepository.save(category);

        product.setParentCategory(category);
        product.setSubCategory(subCategory);

        productRepository.save(product);
        attributes.forEach(attribute -> attribute.setProduct(product));
        product.setAttributes(productAttributeRepository.saveAll(attributes));

        return productMapper.apply(productRepository.save(product));
    }

    @Override
    public ProductResponseDto updateProduct(Long id, ProductRequestDto productRequestDto) {
        Product productFound = getProductById(id);
        ParentCategory category;
        SubCategory subCategory;
        List<ProductAttribute> attributes;

        if (productRequestDto.getName() != null && !productRequestDto.getName().trim().isEmpty())
            productFound.setName(productRequestDto.getName());
        if (productRequestDto.getBrand() != null && !productRequestDto.getBrand().trim().isEmpty())
            productFound.setBrand(productRequestDto.getBrand());
        if (productRequestDto.getModel() != null && !productRequestDto.getModel().trim().isEmpty())
            productFound.setModel(productRequestDto.getModel());
        if (productRequestDto.getPrice() != null && productRequestDto.getPrice() >= 0)
            productFound.setPrice(BigDecimal.valueOf(productRequestDto.getPrice()));
        if (productRequestDto.getQuantity() != null && productRequestDto.getQuantity() >= 0)
            productFound.setQuantity(productRequestDto.getQuantity());

        if (productRequestDto.getCategory() != null && !productRequestDto.getCategory().trim().isEmpty()) {
            category = getCategoryByNameOrCreateNewOne(productRequestDto.getCategory());
            productFound.setParentCategory(category);
        }
        if (productRequestDto.getSubCategory() != null && !productRequestDto.getSubCategory().trim().isEmpty()) {
            subCategory = getSubCategoryByNameOrCreateNewOne(productRequestDto.getSubCategory());
            productFound.setSubCategory(subCategory);
        }

        if (!productRequestDto.getAttributeAndValueMap().isEmpty()) {
            attributes = new ArrayList<>();
            productRequestDto.getAttributeAndValueMap().forEach((attribute, value) -> {
                var attributeFound = getAttributeByAttributeNameAndProductId(attribute, productFound.getId());

                if (attributeFound == null)
                    attributeFound = new ProductAttribute(attribute, value);
                else if (!attributeFound.getValue().equalsIgnoreCase(value))
                    attributeFound.setValue(value);

                attributes.add(attributeFound);
            });

            attributes.forEach(attribute -> {
                if (attribute.getProduct() == null) {
                    attribute.setProduct(productFound);
                    productFound.getAttributes().add(attribute);
                }
            });
            productAttributeRepository.saveAll(attributes);
        }

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
    public Product getProductById(Long id) {
        // TODO: 18/2/2023 change message to a properties value
        return productRepository.findById(id).orElseThrow(() -> new NullPointerException("Product not found"));
    }

    @Override
    public ProductAttribute getAttributeByAttributeNameAndProductId(String attribute, Long productId) {
        return productAttributeRepository.findAttributeByProductId(attribute, productId).orElse(null);
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
