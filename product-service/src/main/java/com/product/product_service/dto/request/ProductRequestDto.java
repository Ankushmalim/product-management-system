package com.product.product_service.dto.request;

import com.product.product_service.enums.*;
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
public class ProductRequestDto {

    @NotBlank(message = "Product name is required")
    @Size(min = 3, max = 200)
    private String name;

    @NotBlank(message = "Slug is required")
    @Pattern(
            regexp = "^[a-z0-9]+(?:-[a-z0-9]+)*$",
            message = "Slug must be lowercase and hyphen separated"
    )
    private String slug;

    @NotBlank(message = "Short description is required")
    @Size(max = 500)
    private String shortDescription;

    @NotBlank(message = "Description is required")
    private String description;

    @NotBlank(message = "SKU is required")
    @Pattern(
            regexp = "^[A-Z0-9_-]+$",
            message = "Invalid SKU format"
    )
    private String sku;

    @NotBlank(message = "Brand is required")
    @Size(max = 100)
    private String brand;

    @NotNull(message = "Category ID is required")
    @Positive
    private Long categoryId;

    @NotNull(message = "Price is required")
    @Positive(message = "Price must be greater than zero")
    private BigDecimal price;

    @PositiveOrZero
    private BigDecimal discountPrice;

    @NotNull(message = "Weight is required")
    @Positive
    private Double weight;

    @NotNull(message = "Weight unit is required")
    private WeightUnit weightUnit;

    @NotNull(message = "Currency is required")
    private CurrencyType currency;

    @NotNull(message = "Product condition is required")
    private ProductCondition productCondition;

    @NotNull(message = "Product status is required")
    private ProductStatus status;

    private Boolean active;

    @NotEmpty(message = "Product images are required")
    @Valid
    private List<ProductImageRequestDto> images;

    @Valid
    private List<ProductSpecificationRequestDto> specifications;

    @Valid
    private List<ProductVariantRequestDto> variants;

}
