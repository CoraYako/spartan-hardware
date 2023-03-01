package com.spartanHardware.model.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductFilterRequest {

    private String category;
    private String subCategory;
}
