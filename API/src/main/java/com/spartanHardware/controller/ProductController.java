package com.spartanHardware.controller;

import com.spartanHardware.model.dto.request.ProductRequestDto;
import com.spartanHardware.model.dto.request.ProductReviewRequestDto;
import com.spartanHardware.model.dto.response.ProductCategoryResponseDto;
import com.spartanHardware.model.dto.response.ProductResponseDto;
import com.spartanHardware.model.dto.response.ProductReviewResponseDto;
import com.spartanHardware.model.dto.response.ProductSubCategoryResponseDto;
import com.spartanHardware.model.entity.User;
import com.spartanHardware.service.IAWSS3Service;
import com.spartanHardware.service.IProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {

    private final IProductService productService;
    private final IAWSS3Service awsS3Service;

    @GetMapping("/details/{id}")
    public ResponseEntity<ProductResponseDto> getProductDetails(@PathVariable Long id) {
        ProductResponseDto productResponseDto = productService.getProductDetails(id);
        return ResponseEntity.status(OK).body(productResponseDto);
    }

    @GetMapping("/all-reviews/{id}")
    public ResponseEntity<Page<ProductReviewResponseDto>> getAllProductReview(@PathVariable Long id,
                                                                              @RequestParam(name = "page") int page) {
        return ResponseEntity.status(OK).body(productService.getAllReviewsByProductId(id, page));
    }

    @GetMapping("/paginated")
    public ResponseEntity<Page<ProductResponseDto>> getAllProducts(@RequestParam(name = "page") int page) {
        return ResponseEntity.status(OK).body(productService.getAllProducts(page));
    }

    @GetMapping("/categories")
    public ResponseEntity<List<ProductCategoryResponseDto>> getAllProductCategories() {
        return ResponseEntity.status(OK).body(productService.getAllProductCategories());
    }

    @GetMapping("/sub-categories")
    public ResponseEntity<List<ProductSubCategoryResponseDto>> getAllProductSubCategories() {
        return ResponseEntity.status(OK).body(productService.getAllProductSubCategories());
    }

    // all bellow endpoints only logged in
    @PostMapping("/review/{id}")
    public ResponseEntity<ProductReviewResponseDto> reviewProduct(@PathVariable Long id,
                                                                  @AuthenticationPrincipal User loggedUser,
                                                                  @Valid @RequestBody ProductReviewRequestDto reviewRequestDto) {
        ProductReviewResponseDto reviewResponseDto = productService.reviewProduct(id, loggedUser, reviewRequestDto);
        return ResponseEntity.status(CREATED).body(reviewResponseDto);
    }

    // all bellow endpoints only admin
    @PostMapping("/warehouse")
    public ResponseEntity<ProductResponseDto> createProduct(@Valid @RequestBody ProductRequestDto productRequestDto) {
        ProductResponseDto productResponseDto = productService.createProduct(productRequestDto);
        return ResponseEntity.status(CREATED).body(productResponseDto);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.status(NO_CONTENT).build();
    }

    @PatchMapping("/update/{id}")
    public ResponseEntity<ProductResponseDto> updateProduct(@PathVariable Long id,
                                                            @RequestBody ProductRequestDto productRequestDto) {
        ProductResponseDto productResponseDto = productService.updateProduct(id, productRequestDto);
        return ResponseEntity.status(OK).body(productResponseDto);
    }

    @PostMapping("/upload-image")
    public ResponseEntity<String> uploadProductImage(@RequestPart(value = "file") MultipartFile file) {
        String response = file.getOriginalFilename();
        return ResponseEntity.status(CREATED).body(response);
    }
}
