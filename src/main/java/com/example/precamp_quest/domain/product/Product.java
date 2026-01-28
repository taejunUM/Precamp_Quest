package com.example.precamp_quest.domain.product;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "price", nullable = false)
    private int price;

    @Column(name = "description")
    private String description;

    @Builder(access = AccessLevel.PRIVATE)
    private Product(
            String name,
            int price,
            String description
    ) {
        this.name = name;
        this.price = price;
        this.description = description;
    }

    public static Product create(
            String name,
            int price,
            String description
    ) {
        return Product.builder()
                .name(name)
                .price(price)
                .description(description)
                .build();
    }

    public void update(
            String name,
            int price,
            String description
    ) {
        this.name = name;
        this.price = price;
        this.description = description;
    }
}
