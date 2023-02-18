package com.spartanHardware.model.dto.response;

import lombok.*;

import java.math.BigDecimal;
import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductResponseDto {

    private Long id;
    private String name;
    private String brand;
    private String model;
    private String category;
    private String subCategory;
    private BigDecimal price;
    private Integer quantity;
    private Map<String, String> attributeAndValueMap;
}
