package com.example.precamp_quest.domain.product.dto;

import com.example.precamp_quest.domain.product.Product;

import java.util.List;

public record ProductResponseDto(
        Long productId,
        String name,
        int price,
        String description
) {
    public static ProductResponseDto toDto(Product product) {
        return new ProductResponseDto(
                product.getId(),
                product.getName(),
                product.getPrice(),
                product.getDescription()
        );
    }

    public static List<ProductResponseDto> toDto(List<Product> products) {
        return products.stream()
                .map(ProductResponseDto::toDto)
                .toList();
    }
}
