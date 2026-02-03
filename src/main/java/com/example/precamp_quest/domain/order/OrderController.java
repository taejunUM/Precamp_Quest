package com.example.precamp_quest.domain.order;

import com.example.precamp_quest.domain.order.dto.request.OrderCreateRequestDto;
import com.example.precamp_quest.domain.order.dto.response.OrderResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/{orderId}")
    public ResponseEntity<OrderResponseDto> findOrder(
            @PathVariable Long orderId
    ) {
        OrderResponseDto response = orderService.findOrder(orderId);

        return ResponseEntity.status(HttpStatus.OK)
                .body(response);
    }

    @GetMapping
    public ResponseEntity<List<OrderResponseDto>> findOrderList() {
        List<OrderResponseDto> response = orderService.findOrderList();

        return ResponseEntity.status(HttpStatus.OK)
                .body(response);
    }
}
