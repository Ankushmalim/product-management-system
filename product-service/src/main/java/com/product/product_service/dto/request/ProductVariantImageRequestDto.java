package com.product.product_service.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductVariantImageRequestDto {

    @NotBlank(message = "Image URL is required")
    private String imageUrl;

}
