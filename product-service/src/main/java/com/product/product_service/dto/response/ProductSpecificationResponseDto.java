package com.product.product_service.dto.response;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductSpecificationResponseDto {

    private Long id;

    private String specKey;

    private String specValue;

}
