package com.product.product_service.dto.response;

import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductVariantResponseDto {

    private Long id;

    private String sku;

    private String color;

    private String size;

    private String storage;

    private BigDecimal price;

    private Boolean active;

    private List<ProductVariantImageResponseDto> images;

}
