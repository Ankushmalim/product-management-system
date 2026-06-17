package com.product.product_service.controller;

import com.product.commonResponse.dto.ApiResponse;
import com.product.product_service.dto.request.ProductRequestDto;
import com.product.product_service.dto.request.ProductUpdateRequestDto;
import com.product.product_service.dto.response.ProductResponseDto;
import com.product.product_service.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public ResponseEntity<ApiResponse<ProductResponseDto>> createProduct(
            @RequestBody @Valid ProductRequestDto dto) {

        ProductResponseDto product = productService.createProduct(dto);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ApiResponseUtil.success(
                        "Product created successfully",
                        product));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<ProductResponseDto>> getProductById(
            @PathVariable Long id) {

        ProductResponseDto product = productService.getProductById(id);
        ApiResponse<ProductResponseDto> response = ApiResponse
                .<ProductResponseDto>builder()
                .success(true)
                .message("Product fetched successfully")
                .timestamp(LocalDateTime.now())
                .data(product)
                .build();
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<ProductResponseDto>> getAllProducts() {

        List<ProductResponseDto> response = productService.getAllProducts();

        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<ProductResponseDto>> updateProduct(
            @PathVariable Long id,
            @Valid @RequestBody ProductRequestDto dto) {

        ProductResponseDto product = productService.updateProduct(id, dto);
        ApiResponse<ProductResponseDto> response = ApiResponse
                .<ProductResponseDto>builder()
                .success(true)
                .message("Product updated successfully")
                .timestamp(LocalDateTime.now())
                .data(product)
                .build();
        return ResponseEntity.ok(response);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ApiResponse<ProductResponseDto>> partialUpdate(
            @PathVariable Long id,
            @RequestBody ProductUpdateRequestDto dto) {
        ProductResponseDto product = productService.partialUpdateProduct(id, dto);

        ApiResponse<ProductResponseDto> response = ApiResponse
                .<ProductResponseDto>builder()
                .success(true)
                .message("Product updated successfully")
                .timestamp(LocalDateTime.now())
                .data(product)
                .build();

        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(
            @PathVariable Long id) {

        productService.deleteProduct(id);

        return ResponseEntity.noContent().build();
    }

}
