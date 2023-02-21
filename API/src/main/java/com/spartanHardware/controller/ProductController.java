package com.spartanHardware.controller;

import com.spartanHardware.model.dto.request.ProductRequestDto;
import com.spartanHardware.model.dto.response.ProductResponseDto;
import com.spartanHardware.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping("/warehouse")
    public ResponseEntity<ProductResponseDto> createProduct(@Valid @RequestBody ProductRequestDto productRequestDto) {
        ProductResponseDto productResponseDto = productService.createProduct(productRequestDto);
        return ResponseEntity.status(CREATED).body(productResponseDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponseDto> getProductDetails(@PathVariable Long id) {
        ProductResponseDto productResponseDto = productService.getProductDetails(id);
        return ResponseEntity.status(OK).body(productResponseDto);
    }

    @DeleteMapping("/{id}")
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

    @GetMapping
    public ResponseEntity<Page<ProductResponseDto>> getAllProducts(@RequestParam(name = "page") int page) {
        return ResponseEntity.status(OK).body(productService.getAllProducts(page));
    }
}
