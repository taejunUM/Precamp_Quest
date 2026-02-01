package com.example.precamp_quest.domain.product.dto.request;

public record ProductUpdateRequestDto(
        String name,
        Integer price,
        String description
) {
}
