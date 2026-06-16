package com.product.product_service.dto.response;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductVariantImageResponseDto {

    private Long id;

    private String imageUrl;

}
