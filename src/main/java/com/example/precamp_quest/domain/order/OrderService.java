package com.example.precamp_quest.domain.order;

import com.example.precamp_quest.domain.order.dto.request.OrderCreateRequestDto;
import com.example.precamp_quest.domain.order.dto.response.OrderResponseDto;
import com.example.precamp_quest.domain.product.Product;
import com.example.precamp_quest.domain.product.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class OrderService {

    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;

    @Transactional
    public OrderResponseDto createOrder(OrderCreateRequestDto dto) {
        Product product = productRepository.findById(dto.productId())
                .orElseThrow(() -> new IllegalArgumentException("not found product"));

        Order order = Order.create(product);

        return OrderResponseDto.toDto(orderRepository.save(order));
    }

}
