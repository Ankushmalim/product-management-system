package com.product.product_service.service.serviceImpl;

import com.product.commonexception.exception.ResourceAlreadyExistsException;
import com.product.commonexception.exception.ResourceNotFoundException;
import com.product.product_service.dto.request.ProductRequestDto;
import com.product.product_service.dto.response.ProductResponseDto;
import com.product.product_service.entity.Product;
import com.product.product_service.mapper.ProductMapper;
import com.product.product_service.repository.ProductRepository;
import com.product.product_service.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public ProductResponseDto createProduct(ProductRequestDto dto) {

        validateDuplicateFields(dto);

        Product product = ProductMapper.toEntity(dto);

        Product savedProduct = productRepository.save(product);

        return ProductMapper.toResponse(savedProduct);
    }

    @Override
    public ProductResponseDto getProductById(Long id) {

        Product product = getProduct(id);

        return ProductMapper.toResponse(product);
    }

    @Override
    public List<ProductResponseDto> getAllProducts() {

        return productRepository.findAll()
                .stream()
                .map(ProductMapper::toResponse)
                .toList();
    }

    @Override
    public ProductResponseDto updateProduct(Long id, ProductRequestDto dto) {

        Product existingProduct = getProduct(id);

        validateUpdate(existingProduct, dto);

        ProductMapper.updateEntity(existingProduct, dto);

        Product savedProduct = productRepository.save(existingProduct);

        return ProductMapper.toResponse(savedProduct);
    }

    @Override
    public void deleteProduct(Long id) {

        Product product = getProduct(id);

        productRepository.delete(product);
    }

    // ---------------- Private Helper Methods ----------------

    private Product getProduct(Long id) {

        return productRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Product not found with id : " + id));
    }

    private void validateDuplicateFields(ProductRequestDto dto) {

        if (productRepository.existsBySku(dto.getSku())) {
            throw new ResourceAlreadyExistsException(
                    "Product already exists with SKU : " + dto.getSku());
        }

        if (productRepository.existsBySlug(dto.getSlug())) {
            throw new ResourceAlreadyExistsException(
                    "Product already exists with Slug : " + dto.getSlug());
        }
    }

    private void validateUpdate(Product existing, ProductRequestDto dto) {

        if (!existing.getSku().equals(dto.getSku())
                && productRepository.existsBySku(dto.getSku())) {

            throw new ResourceAlreadyExistsException(
                    "Product already exists with SKU : " + dto.getSku());
        }

        if (!existing.getSlug().equals(dto.getSlug())
                && productRepository.existsBySlug(dto.getSlug())) {

            throw new ResourceAlreadyExistsException(
                    "Product already exists with Slug : " + dto.getSlug());
        }
    }

}
