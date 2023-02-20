package com.spartanHardware.model.mapper;

import com.spartanHardware.model.dto.request.ProductRequestDto;
import com.spartanHardware.model.dto.response.ProductResponseDto;
import com.spartanHardware.model.entity.Product;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.function.Function;

@Component
public class ProductMapper implements Function<Product, ProductResponseDto> {

    public Product toEntity(ProductRequestDto productRequestDto) {
        Product product = new Product();
        product.setName(productRequestDto.getName());
        product.setBrand(productRequestDto.getBrand());
        product.setModel(productRequestDto.getModel());
        product.setPrice(BigDecimal.valueOf(productRequestDto.getPrice()));
        product.setQuantity(productRequestDto.getQuantity());

        return product;
    }

    @Override
    public ProductResponseDto apply(Product product) {
        ProductResponseDto productResponseDto = new ProductResponseDto();

        // TODO: 18/2/2023 Find the best practice to initialize the HashMap
        productResponseDto.setAttributeAndValueMap(new HashMap<>());

        productResponseDto.setId(product.getId());
        productResponseDto.setName(product.getName());
        productResponseDto.setBrand(product.getBrand());
        productResponseDto.setModel(product.getModel());
        productResponseDto.setPrice(product.getPrice());
        productResponseDto.setQuantity(product.getQuantity());
        productResponseDto.setCategory(product.getParentCategory().getCategory());
        productResponseDto.setSubCategory(product.getSubCategory().getSubCategory());

        product.getAttributes().forEach(
                productAttribute -> {
                    productResponseDto.getAttributeAndValueMap()
                            .put(productAttribute.getAttribute(), productAttribute.getValue());
                }
        );

        return productResponseDto;
    }
}
