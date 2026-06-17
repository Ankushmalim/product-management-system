package com.product.product_service.mapper;

import com.product.product_service.dto.request.ProductRequestDto;
import com.product.product_service.dto.request.ProductUpdateRequestDto;
import com.product.product_service.dto.response.ProductResponseDto;
import com.product.product_service.entity.Product;
import com.product.product_service.entity.ProductImage;
import com.product.product_service.entity.ProductSpecification;
import com.product.product_service.entity.ProductVariant;

import java.util.List;

public final class ProductMapper {

    private ProductMapper() {
    }

    public static Product toEntity(ProductRequestDto dto) {

        if (dto == null) {
            return null;
        }

        Product product = Product.builder()
                .name(dto.getName())
                .slug(dto.getSlug())
                .shortDescription(dto.getShortDescription())
                .description(dto.getDescription())
                .sku(dto.getSku())
                .brand(dto.getBrand())
                .categoryId(dto.getCategoryId())
                .price(dto.getPrice())
                .discountPrice(dto.getDiscountPrice())
                .weight(dto.getWeight())
                .weightUnit(dto.getWeightUnit())
                .currency(dto.getCurrency())
                .productCondition(dto.getProductCondition())
                .status(dto.getStatus())
                .active(dto.getActive())
                .build();

        // ---------------- Images ----------------

        if (dto.getImages() != null && !dto.getImages().isEmpty()) {

            List<ProductImage> images = dto.getImages()
                    .stream()
                    .map(ProductImageMapper::toEntity)
                    .toList();

            images.forEach(image -> image.setProduct(product));

            product.setImages(images);
        }

        // ---------------- Specifications ----------------

        if (dto.getSpecifications() != null && !dto.getSpecifications().isEmpty()) {

            List<ProductSpecification> specifications =
                    dto.getSpecifications()
                            .stream()
                            .map(ProductSpecificationMapper::toEntity)
                            .toList();

            specifications.forEach(spec -> spec.setProduct(product));

            product.setSpecifications(specifications);
        }

        // ---------------- Variants ----------------

        if (dto.getVariants() != null && !dto.getVariants().isEmpty()) {

            List<ProductVariant> variants =
                    dto.getVariants()
                            .stream()
                            .map(ProductVariantMapper::toEntity)
                            .toList();

            variants.forEach(variant -> variant.setProduct(product));

            product.setVariants(variants);
        }

        return product;
    }

    public static ProductResponseDto toResponse(Product entity) {

        if (entity == null) {
            return null;
        }

        return ProductResponseDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .slug(entity.getSlug())
                .shortDescription(entity.getShortDescription())
                .description(entity.getDescription())
                .sku(entity.getSku())
                .brand(entity.getBrand())
                .categoryId(entity.getCategoryId())
                .price(entity.getPrice())
                .discountPrice(entity.getDiscountPrice())
                .weight(entity.getWeight())
                .weightUnit(entity.getWeightUnit())
                .currency(entity.getCurrency())
                .productCondition(entity.getProductCondition())
                .status(entity.getStatus())
                .active(entity.getActive())

                .images(
                        entity.getImages() == null
                                ? List.of()
                                : entity.getImages()
                                .stream()
                                .map(ProductImageMapper::toResponse)
                                .toList()
                )

                .specifications(
                        entity.getSpecifications() == null
                                ? List.of()
                                : entity.getSpecifications()
                                .stream()
                                .map(ProductSpecificationMapper::toResponse)
                                .toList()
                )

                .variants(
                        entity.getVariants() == null
                                ? List.of()
                                : entity.getVariants()
                                .stream()
                                .map(ProductVariantMapper::toResponse)
                                .toList()
                )

                .build();
    }

    public static void updateEntity(Product product, ProductRequestDto dto) {

        if (product == null || dto == null) {
            return;
        }

        product.setName(dto.getName());
        product.setSlug(dto.getSlug());
        product.setShortDescription(dto.getShortDescription());
        product.setDescription(dto.getDescription());
        product.setSku(dto.getSku());
        product.setBrand(dto.getBrand());
        product.setCategoryId(dto.getCategoryId());
        product.setPrice(dto.getPrice());
        product.setDiscountPrice(dto.getDiscountPrice());
        product.setWeight(dto.getWeight());
        product.setWeightUnit(dto.getWeightUnit());
        product.setCurrency(dto.getCurrency());
        product.setProductCondition(dto.getProductCondition());
        product.setStatus(dto.getStatus());
        product.setActive(dto.getActive());

        // ---------- Images ----------

        product.getImages().clear();

        if (dto.getImages() != null && !dto.getImages().isEmpty()) {

            dto.getImages()
                    .stream()
                    .map(ProductImageMapper::toEntity)
                    .forEach(image -> {
                        image.setProduct(product);
                        product.getImages().add(image);
                    });
        }

        // ---------- Specifications ----------

        product.getSpecifications().clear();

        if (dto.getSpecifications() != null && !dto.getSpecifications().isEmpty()) {

            dto.getSpecifications()
                    .stream()
                    .map(ProductSpecificationMapper::toEntity)
                    .forEach(spec -> {
                        spec.setProduct(product);
                        product.getSpecifications().add(spec);
                    });
        }

        // ---------- Variants ----------

        product.getVariants().clear();

        if (dto.getVariants() != null && !dto.getVariants().isEmpty()) {

            dto.getVariants()
                    .stream()
                    .map(ProductVariantMapper::toEntity)
                    .forEach(variant -> {
                        variant.setProduct(product);
                        product.getVariants().add(variant);
                    });
        }

    }

    public static void partialUpdate(Product product,
                                     ProductUpdateRequestDto dto) {

        if (dto == null || product == null) {
            return;
        }

        if (dto.getName() != null)
            product.setName(dto.getName());

        if (dto.getSlug() != null)
            product.setSlug(dto.getSlug());

        if (dto.getShortDescription() != null)
            product.setShortDescription(dto.getShortDescription());

        if (dto.getDescription() != null)
            product.setDescription(dto.getDescription());

        if (dto.getSku() != null)
            product.setSku(dto.getSku());

        if (dto.getBrand() != null)
            product.setBrand(dto.getBrand());

        if (dto.getCategoryId() != null)
            product.setCategoryId(dto.getCategoryId());

        if (dto.getPrice() != null)
            product.setPrice(dto.getPrice());

        if (dto.getDiscountPrice() != null)
            product.setDiscountPrice(dto.getDiscountPrice());

        if (dto.getWeight() != null)
            product.setWeight(dto.getWeight());

        if (dto.getWeightUnit() != null)
            product.setWeightUnit(dto.getWeightUnit());

        if (dto.getCurrency() != null)
            product.setCurrency(dto.getCurrency());

        if (dto.getProductCondition() != null)
            product.setProductCondition(dto.getProductCondition());

        if (dto.getStatus() != null)
            product.setStatus(dto.getStatus());

        if (dto.getActive() != null)
            product.setActive(dto.getActive());

        // Images, Specifications, Variants
        // We'll handle these separately because collection updates
        // require more than a simple field assignment.
    }

}