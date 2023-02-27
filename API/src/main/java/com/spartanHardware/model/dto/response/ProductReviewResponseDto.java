package com.spartanHardware.model.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductReviewResponseDto {

    private Long id;
    private String user;
    private String product;
    private Integer rate;
    private String comment;
    private LocalDateTime creationDate;
}
