package com.spartanHardware.controller;

import com.spartanHardware.model.dto.request.ProductRequestDto;
import com.spartanHardware.model.dto.request.ProductReviewRequestDto;
import com.spartanHardware.model.dto.response.*;
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

    @GetMapping("/search")
    public ResponseEntity<Page<ProductResponseDto>> getProductsBySearch(@RequestParam(name = "query") String productName,
                                                                        @RequestParam(name = "page") int page) {
        return ResponseEntity.status(OK).body(productService.getProductsFilteredByName(productName, page));
    }

    @GetMapping("/filter")
    public ResponseEntity<Page<ProductResponseDto>> getProductsByCategories(@RequestParam(required = false, name = "category") String category,
                                                                            @RequestParam(required = false, name = "subCategory") String subCategory,
                                                                            @RequestParam(name = "page") int page) {
        return ResponseEntity.status(OK).body(productService.getProductsFilteredByCategories(category, subCategory, page));
    }
    @GetMapping("/recommended")
    public ResponseEntity<List<ProductResponseDto>> getAllProductsRecommended() {
        return ResponseEntity.status(OK).body(productService.getAllProductsRecommended());
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
    public ResponseEntity<ImageURLResponseDto> uploadProductImage(@RequestPart(value = "file") MultipartFile file) {
        ImageURLResponseDto responseDto = awsS3Service.uploadFile(file);
        return ResponseEntity.status(CREATED).body(responseDto);
    }
}
