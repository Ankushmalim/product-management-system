package com.product.product_service.mapper;

import com.product.product_service.dto.request.ProductVariantImageRequestDto;
import com.product.product_service.dto.response.ProductVariantImageResponseDto;
import com.product.product_service.entity.ProductVariantImage;

public final class ProductVariantImageMapper {

    private ProductVariantImageMapper() {
    }

    public static ProductVariantImage toEntity(ProductVariantImageRequestDto dto) {

        if (dto == null) {
            return null;
        }

        return ProductVariantImage.builder()
                .imageUrl(dto.getImageUrl())
                .build();
    }

    public static ProductVariantImageResponseDto toResponse(ProductVariantImage entity) {

        if (entity == null) {
            return null;
        }

        return ProductVariantImageResponseDto.builder()
                .id(entity.getId())
                .imageUrl(entity.getImageUrl())
                .build();
    }

}