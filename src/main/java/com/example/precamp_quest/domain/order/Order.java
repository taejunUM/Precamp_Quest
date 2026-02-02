package com.example.precamp_quest.domain.order;

import com.example.precamp_quest.domain.product.Product;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @Builder(access = AccessLevel.PRIVATE)
    private Order(Product product) {
        this.product = product;
    }

    public static Order create(Product product) {
        return Order.builder()
                .product(product)
                .build();
    }
}
