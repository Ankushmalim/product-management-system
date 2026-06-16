package com.product.product_service.dto.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductVariantRequestDto {

    @NotBlank(message = "Variant SKU is required")
    @Pattern(
            regexp = "^[A-Z0-9_-]+$",
            message = "SKU can contain only uppercase letters, numbers, underscore and hyphen"
    )
    private String sku;

    @NotBlank(message = "Color is required")
    private String color;

    @NotBlank(message = "Size is required")
    private String size;

    @NotBlank(message = "Storage is required")
    private String storage;

    @NotNull(message = "Variant price is required")
    @Positive(message = "Price must be greater than zero")
    private BigDecimal price;

    private Boolean active;

    @NotEmpty(message = "At least one variant image is required")
    @Valid
    private List<ProductVariantImageRequestDto> images;

}