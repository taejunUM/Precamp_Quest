package com.example.precamp_quest.domain.order.dto.response;

import com.example.precamp_quest.domain.order.Order;

public record OrderResponseDto(
        Long orderId,
        Long productId,
        String productName
) {
    public static OrderResponseDto toDto(Order order) {
        return new OrderResponseDto(
                order.getId(),
                order.getProduct().getId(),
                order.getProduct().getName()
        );
    }
}
