package com.example.precamp_quest.domain.product;

import com.example.precamp_quest.domain.product.dto.ProductCreateRequestDto;
import com.example.precamp_quest.domain.product.dto.ProductResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository repository;

    public ProductResponseDto create(ProductCreateRequestDto dto) {

        Product product = Product.create(
                dto.name(),
                dto.price(),
                dto.description()
        );

        Product saved = repository.save(product);

        return ProductResponseDto.toDto(saved);
    }
}
