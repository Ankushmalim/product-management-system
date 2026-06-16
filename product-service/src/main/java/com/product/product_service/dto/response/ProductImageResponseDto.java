package com.product.product_service.dto.response;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductImageResponseDto {

    private Long id;

    private String imageUrl;

    private String altText;

    private Boolean primaryImage;

}
