package com.spartanHardware.model.dto.request;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductReviewRequestDto {

    @NotNull(message = "Must rate the product")
    @Min(value = 1, message = "Rate the product from 1 to 5")
    @Max(value = 5, message = "Rate the product from 1 to 5")
    private Integer rate;

    @NotEmpty(message = "Comment cannot be null")
    @NotBlank(message = "The comment cannot be whitespaces")
    private String comment;
}
