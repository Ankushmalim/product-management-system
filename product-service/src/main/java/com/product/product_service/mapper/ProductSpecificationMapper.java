package com.product.product_service.mapper;

import com.product.product_service.dto.request.ProductSpecificationRequestDto;
import com.product.product_service.dto.response.ProductSpecificationResponseDto;
import com.product.product_service.entity.ProductSpecification;

public final class ProductSpecificationMapper {

    private ProductSpecificationMapper() {
    }

    public static ProductSpecification toEntity(ProductSpecificationRequestDto dto) {

        if (dto == null) {
            return null;
        }

        return ProductSpecification.builder()
                .specKey(dto.getSpecKey())
                .specValue(dto.getSpecValue())
                .build();
    }

    public static ProductSpecificationResponseDto toResponse(ProductSpecification entity) {

        if (entity == null) {
            return null;
        }

        return ProductSpecificationResponseDto.builder()
                .id(entity.getId())
                .specKey(entity.getSpecKey())
                .specValue(entity.getSpecValue())
                .build();
    }

}