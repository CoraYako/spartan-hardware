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
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Boolean.FALSE;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

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
    public ParentCategory getCategoryByNameOrCreateNewOne(String category) {
        return categoryRepository.findByCategory(category)
                .orElseGet(() -> categoryRepository.save(new ParentCategory(category)));
    }

    @Override
    public SubCategory getSubCategoryByNameOrCreateNewOne(String subCategory) {
        return subCategoryRepository.findBySubCategory(subCategory)
                .orElseGet(() -> subCategoryRepository.save(new SubCategory(subCategory)));
    }
}
