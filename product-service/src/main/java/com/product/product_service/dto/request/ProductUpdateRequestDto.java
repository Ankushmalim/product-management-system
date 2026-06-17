package com.product.product_service.dto.request;

import com.product.product_service.enums.CurrencyType;
import com.product.product_service.enums.ProductCondition;
import com.product.product_service.enums.ProductStatus;
import com.product.product_service.enums.WeightUnit;
import jakarta.validation.Valid;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductUpdateRequestDto {

    @Size(min = 3, max = 150, message = "Product name must be between 3 and 150 characters")
    private String name;

    @Pattern(
            regexp = "^[a-z0-9]+(?:-[a-z0-9]+)*$",
            message = "Slug must contain only lowercase letters, numbers and hyphens"
    )
    private String slug;

    @Size(max = 255, message = "Short description cannot exceed 255 characters")
    private String shortDescription;

    @Size(max = 5000, message = "Description cannot exceed 5000 characters")
    private String description;

    @Pattern(
            regexp = "^[A-Z0-9_-]+$",
            message = "SKU can contain only uppercase letters, numbers, underscore and hyphen"
    )
    private String sku;

    @Size(max = 100)
    private String brand;

    private Long categoryId;

    @DecimalMin(value = "0.0", inclusive = false,
            message = "Price must be greater than zero")
    private BigDecimal price;

    @DecimalMin(value = "0.0", inclusive = false,
            message = "Discount price must be greater than zero")
    private BigDecimal discountPrice;

    @DecimalMin(value = "0.0", inclusive = false,
            message = "Weight must be greater than zero")
    private Double weight;

    private WeightUnit weightUnit;

    private CurrencyType currency;

    private ProductCondition productCondition;

    private ProductStatus status;

    private Boolean active;

    @Valid
    private List<ProductImageRequestDto> images;

    @Valid
    private List<ProductSpecificationRequestDto> specifications;

    @Valid
    private List<ProductVariantRequestDto> variants;

}
