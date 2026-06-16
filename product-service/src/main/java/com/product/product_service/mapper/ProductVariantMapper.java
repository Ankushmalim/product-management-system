package com.product.product_service.mapper;

import com.product.product_service.dto.request.ProductVariantRequestDto;
import com.product.product_service.dto.response.ProductVariantResponseDto;
import com.product.product_service.entity.ProductVariant;
import com.product.product_service.entity.ProductVariantImage;

import java.util.List;

public final class ProductVariantMapper {

    private ProductVariantMapper() {
    }

    public static ProductVariant toEntity(ProductVariantRequestDto dto) {

        if (dto == null) {
            return null;
        }

        ProductVariant variant = ProductVariant.builder()
                .sku(dto.getSku())
                .color(dto.getColor())
                .size(dto.getSize())
                .storage(dto.getStorage())
                .price(dto.getPrice())
                .active(dto.getActive())
                .build();

        if (dto.getImages() != null && !dto.getImages().isEmpty()) {

            List<ProductVariantImage> images = dto.getImages()
                    .stream()
                    .map(ProductVariantImageMapper::toEntity)
                    .toList();

            images.forEach(image -> image.setVariant(variant));

            variant.setImages(images);
        }

        return variant;
    }

    public static ProductVariantResponseDto toResponse(ProductVariant entity) {

        if (entity == null) {
            return null;
        }

        return ProductVariantResponseDto.builder()
                .id(entity.getId())
                .sku(entity.getSku())
                .color(entity.getColor())
                .size(entity.getSize())
                .storage(entity.getStorage())
                .price(entity.getPrice())
                .active(entity.getActive())
                .images(
                        entity.getImages() == null
                                ? List.of()
                                : entity.getImages()
                                .stream()
                                .map(ProductVariantImageMapper::toResponse)
                                .toList()
                )
                .build();
    }

}