package com.example.precamp_quest.domain.order;

import com.example.precamp_quest.domain.order.dto.response.OrderResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface OrderRepository extends JpaRepository<Order, Long> {

    @Query("""
            select new com.example.precamp_quest.domain.order.dto.response.OrderResponseDto(
                    o.id,
                    p.id,
                    p.name
                )
            from Order o
            join o.product p
            """)
    Page<OrderResponseDto> findOrderPage(Pageable pageable);
}
