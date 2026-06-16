package com.product.product_service.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="product_variant_images")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductVariantImage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String imageUrl;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="variant_id")
    private ProductVariant variant;

}
