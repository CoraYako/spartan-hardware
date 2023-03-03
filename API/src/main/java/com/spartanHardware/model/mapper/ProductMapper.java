package com.spartanHardware.model.mapper;

import com.spartanHardware.model.dto.request.ProductRequestDto;
import com.spartanHardware.model.dto.response.ProductResponseDto;
import com.spartanHardware.model.entity.Image;
import com.spartanHardware.model.entity.Product;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.function.Function;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

@Component
public class ProductMapper implements Function<Product, ProductResponseDto> {

    public Product toEntity(ProductRequestDto productRequestDto) {
        Product product = new Product();

        product.setName(productRequestDto.getName());
        product.setBrand(productRequestDto.getBrand());
        product.setModel(productRequestDto.getModel());
        product.setShortDescription(productRequestDto.getShortDescription());
        product.setDescription(productRequestDto.getDescription());
        product.setPrice(BigDecimal.valueOf(productRequestDto.getPrice()));
        product.setQuantity(productRequestDto.getQuantity());

        if (productRequestDto.getSpecialPrice() != null && productRequestDto.getSpecialPrice() > 0)
            product.setSpecialPrice(BigDecimal.valueOf(productRequestDto.getSpecialPrice()));

        return product;
    }

    @Override
    public ProductResponseDto apply(Product product) {
        ProductResponseDto productResponseDto = new ProductResponseDto();

        productResponseDto.setId(product.getId());
        productResponseDto.setName(product.getName());
        productResponseDto.setBrand(product.getBrand());
        productResponseDto.setModel(product.getModel());
        productResponseDto.setUrlImages(
                product.getProductImages()
                        .stream()
                        .map(Image::getSrc).toList()
        );
        productResponseDto.setCategory(product.getParentCategory().getCategory());
        productResponseDto.setSubCategory(product.getSubCategory().getSubCategory());
        productResponseDto.setShortDescription(product.getShortDescription());
        productResponseDto.setDescription(product.getDescription());
        productResponseDto.setRecommended(product.isRecommended());
        productResponseDto.setPrice(product.getPrice());
        productResponseDto.setSpecialPrice(product.getSpecialPrice());
        productResponseDto.setQuantity(product.getQuantity());
        productResponseDto.setAvailable(product.getAvailable());
        productResponseDto.setInStockSince(product.getInStockSince());
        productResponseDto.setUpdateDate(product.getUpdateDate());
        productResponseDto.setFastShipping(product.isFastShipping());

        return productResponseDto;
    }

    public Product refreshValues(Product product, ProductRequestDto productRequestDto) {
        if (productRequestDto.getName() != null && !productRequestDto.getName().trim().isEmpty())
            product.setName(productRequestDto.getName());
        if (productRequestDto.getBrand() != null && !productRequestDto.getBrand().trim().isEmpty())
            product.setBrand(productRequestDto.getBrand());
        if (productRequestDto.getModel() != null && !productRequestDto.getModel().trim().isEmpty())
            product.setModel(productRequestDto.getModel());
        if (productRequestDto.getShortDescription() != null && !productRequestDto.getShortDescription().trim().isEmpty())
            product.setShortDescription(productRequestDto.getShortDescription());
        if (productRequestDto.getDescription() != null && !productRequestDto.getDescription().trim().isEmpty())
            product.setDescription(productRequestDto.getDescription());
        if (productRequestDto.isRecommended())
            product.setRecommended(TRUE);
        if (productRequestDto.getPrice() != null && productRequestDto.getPrice() >= 0)
            product.setPrice(BigDecimal.valueOf(productRequestDto.getPrice()));
        if (productRequestDto.getSpecialPrice() != null && productRequestDto.getSpecialPrice() >= 0)
            product.setSpecialPrice(BigDecimal.valueOf(productRequestDto.getSpecialPrice()));
        if (productRequestDto.getQuantity() != null && productRequestDto.getQuantity() >= 0)
            product.setQuantity(productRequestDto.getQuantity());
        if (!productRequestDto.isAvailable())
            product.setAvailable(FALSE);

        return product;
    }
}
