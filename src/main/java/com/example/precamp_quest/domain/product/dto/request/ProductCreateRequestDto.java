package com.example.precamp_quest.domain.product.dto.request;

public record ProductCreateRequestDto(
        String name,
        int price,
        String description
) {
}
