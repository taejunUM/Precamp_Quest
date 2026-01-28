package com.example.precamp_quest.domain.product;

import com.example.precamp_quest.domain.product.dto.ProductCreateRequestDto;
import com.example.precamp_quest.domain.product.dto.ProductResponseDto;
import com.example.precamp_quest.domain.product.dto.ProductUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping
    public ResponseEntity<List<ProductResponseDto>> findProductList() {
        List<ProductResponseDto> response = productService.findProductList();

        return ResponseEntity.status(HttpStatus.OK)
                .body(response);
    }

    @PatchMapping("/{productId}")
    public ResponseEntity<ProductResponseDto> updateProduct(
            @PathVariable Long productId,
            @RequestBody ProductUpdateRequestDto dto
    ) {
        ProductResponseDto response = productService.updateProduct(productId, dto);

        return ResponseEntity.status(HttpStatus.OK)
                .body(response);
    }

    @DeleteMapping("/{productId}")
    public ResponseEntity<Void> deleteProduct(
            @PathVariable Long productId
    ) {
        productService.deleteProduct(productId);

        return ResponseEntity.status(HttpStatus.NO_CONTENT)
                .build();
    }
}
