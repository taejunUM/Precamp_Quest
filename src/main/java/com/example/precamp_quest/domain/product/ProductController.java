package com.example.precamp_quest.domain.product;

import com.example.precamp_quest.domain.product.dto.ProductCreateRequestDto;
import com.example.precamp_quest.domain.product.dto.ProductResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public ResponseEntity<ProductResponseDto> create(
            @RequestBody ProductCreateRequestDto dto
    ) {
        ProductResponseDto response = productService.createProduct(dto);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(response);
    }

    @GetMapping("/{productId}")
    public ResponseEntity<ProductResponseDto> findProduct(
            @PathVariable Long productId
    ) {
        ProductResponseDto response = productService.findProduct(productId);

        return ResponseEntity.status(HttpStatus.OK)
                .body(response);
    }
}
