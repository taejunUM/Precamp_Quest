package com.example.precamp_quest.domain.product;

import com.example.precamp_quest.domain.product.dto.ProductCreateRequestDto;
import com.example.precamp_quest.domain.product.dto.ProductResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository repository;

    public ProductResponseDto createProduct(ProductCreateRequestDto dto) {
        Product product = Product.create(
                dto.name(),
                dto.price(),
                dto.description()
        );

        Product saved = repository.save(product);

        return ProductResponseDto.toDto(saved);
    }

    public ProductResponseDto findProduct(Long productId) {
        Product product = repository.findById(productId)
                .orElseThrow(() -> new IllegalArgumentException("not found product"));

        return ProductResponseDto.toDto(product);
    }
}
