package com.product.product_service.controller;

import com.product.product_service.dto.request.ProductRequestDto;
import com.product.product_service.dto.request.ProductUpdateRequestDto;
import com.product.product_service.dto.response.ProductResponseDto;
import com.product.product_service.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public ResponseEntity<ProductResponseDto> createProduct(
            @Valid @RequestBody ProductRequestDto dto) {

        ProductResponseDto response = productService.createProduct(dto);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponseDto> getProductById(
            @PathVariable Long id) {

        ProductResponseDto response = productService.getProductById(id);

        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<ProductResponseDto>> getAllProducts() {

        List<ProductResponseDto> response = productService.getAllProducts();

        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductResponseDto> updateProduct(
            @PathVariable Long id,
            @Valid @RequestBody ProductRequestDto dto) {

        ProductResponseDto response = productService.updateProduct(id, dto);

        return ResponseEntity.ok(response);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ProductResponseDto> partialUpdate(
            @PathVariable Long id,
            @RequestBody ProductUpdateRequestDto dto) {

        return ResponseEntity.ok(
                productService.partialUpdateProduct(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(
            @PathVariable Long id) {

        productService.deleteProduct(id);

        return ResponseEntity.noContent().build();
    }

}
