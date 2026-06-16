package com.product.product_service.mapper;

import com.product.product_service.dto.request.ProductImageRequestDto;
import com.product.product_service.dto.response.ProductImageResponseDto;
import com.product.product_service.entity.ProductImage;

public final class ProductImageMapper {

    private ProductImageMapper() {
    }

    public static ProductImage toEntity(ProductImageRequestDto dto) {

        if (dto == null) {
            return null;
        }

        return ProductImage.builder()
                .imageUrl(dto.getImageUrl())
                .altText(dto.getAltText())
                .primaryImage(dto.getPrimaryImage())
                .build();
    }

    public static ProductImageResponseDto toResponse(ProductImage entity) {

        if (entity == null) {
            return null;
        }

        return ProductImageResponseDto.builder()
                .id(entity.getId())
                .imageUrl(entity.getImageUrl())
                .altText(entity.getAltText())
                .primaryImage(entity.getPrimaryImage())
                .build();
    }

}