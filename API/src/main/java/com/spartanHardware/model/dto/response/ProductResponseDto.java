package com.spartanHardware.model.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductResponseDto {

    private Long id;
    private String name;
    private String brand;
    private String model;
    private List<String> urlImages;
    private String category;
    private String subCategory;
    private String shortDescription;
    private String description;
    private boolean recommended;
    private BigDecimal price;
    private BigDecimal specialPrice;
    private Integer quantity;
    private boolean available;
    private LocalDateTime inStockSince;
    private LocalDateTime updateDate;
    private boolean fastShipping;
}
