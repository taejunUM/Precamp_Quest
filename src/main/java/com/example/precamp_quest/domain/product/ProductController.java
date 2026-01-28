package com.example.precamp_quest.domain.product;

import com.example.precamp_quest.domain.product.dto.ProductCreateRequestDto;
import com.example.precamp_quest.domain.product.dto.ProductResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public ResponseEntity<ProductResponseDto> create(
            @RequestBody ProductCreateRequestDto dto
    ) {
        ProductResponseDto response = productService.create(dto);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(response);
    }
}
