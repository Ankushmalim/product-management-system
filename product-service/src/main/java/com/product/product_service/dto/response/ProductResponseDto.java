package com.product.product_service.dto.response;
import com.product.product_service.enums.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductResponseDto {

    private Long id;

    private String name;

    private String slug;

    private String shortDescription;

    private String description;

    private String sku;

    private String brand;

    private Long categoryId;

    private BigDecimal price;

    private BigDecimal discountPrice;

    private Double weight;

    private WeightUnit weightUnit;

    private CurrencyType currency;

    private ProductCondition productCondition;

    private ProductStatus status;

    private Boolean active;

    private List<ProductImageResponseDto> images;

    private List<ProductSpecificationResponseDto> specifications;

    private List<ProductVariantResponseDto> variants;

}
