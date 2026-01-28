package com.example.precamp_quest.domain.product.dto;

import com.example.precamp_quest.domain.product.Product;

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
}
