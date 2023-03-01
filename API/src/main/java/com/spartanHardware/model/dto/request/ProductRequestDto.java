package com.spartanHardware.model.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductRequestDto {

    @NotEmpty(message = "Must specify the name")
    @NotBlank(message = "Product name cannot be whitespaces")
    private String name;
    @NotEmpty(message = "Must specify the brand")
    @NotBlank(message = "Product brand cannot be whitespaces")
    private String brand;
    @NotEmpty(message = "Must specify the brand")
    @NotBlank(message = "Product model cannot be whitespaces")
    private String model;
    @NotNull(message = "Needs to set the ulr for product images")
    private List<String> images;
    @NotEmpty(message = "Category is mandatory")
    @NotBlank(message = "Product category cannot be whitespaces")
    private String category;
    private String subCategory;
    @NotEmpty(message = "The product needs a short description")
    @NotBlank(message = "Product short description cannot be whitespaces")
    private String shortDescription;
    @NotEmpty(message = "Must specify a description")
    @NotBlank(message = "Product description cannot be whitespaces")
    private String description;
    private boolean recommended;
    @NotNull(message = "The price cannot be null")
    @Min(message = "Min value for price is $1.00", value = 1L)
    private Double price;
    private Double specialPrice;
    @NotNull(message = "The quantity cannot be null")
    @Min(message = "Min value for quantity is 1", value = 1)
    private Integer quantity;
    private boolean available;
    private boolean fastShipping;
}
