package com.spartanHardware.model.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductRequestDto {

    @NotBlank(message = "Product name is mandatory")
    private String name;
    @NotEmpty(message = "Must specify the brand")
    private String brand;
    private String model;
    private String category;
    private String subCategory;
    private Double price;
    private Integer quantity;
    private Map<String, String> attributeAndValueMap;
}
