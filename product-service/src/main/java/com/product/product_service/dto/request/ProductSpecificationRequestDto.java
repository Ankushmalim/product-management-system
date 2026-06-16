package com.product.product_service.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductSpecificationRequestDto {

    @NotBlank(message = "Specification key is required")
    @Size(max = 100)
    private String specKey;

    @NotBlank(message = "Specification value is required")
    @Size(max = 300)
    private String specValue;

}