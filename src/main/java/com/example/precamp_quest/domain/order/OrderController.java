package com.example.precamp_quest.domain.order;

import com.example.precamp_quest.domain.order.dto.request.OrderCreateRequestDto;
import com.example.precamp_quest.domain.order.dto.response.OrderResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    public ResponseEntity<OrderResponseDto> create(
            @RequestBody OrderCreateRequestDto dto
    ) {
        OrderResponseDto response = orderService.createOrder(dto);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(response);
    }
}
