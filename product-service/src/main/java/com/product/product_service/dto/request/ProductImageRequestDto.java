package com.product.product_service.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductImageRequestDto {

    @NotBlank(message = "Image URL is required")
    private String imageUrl;

    @NotBlank(message = "Alt text is required")
    private String altText;

    private Boolean primaryImage;
}
