package com.example.precamp_quest.domain.product;

import com.example.precamp_quest.domain.product.dto.request.ProductCreateRequestDto;
import com.example.precamp_quest.domain.product.dto.response.ProductResponseDto;
import com.example.precamp_quest.domain.product.dto.request.ProductUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ProductService {

    private final ProductRepository repository;

    @Transactional
    public ProductResponseDto createProduct(ProductCreateRequestDto dto) {
        Product product = Product.create(
                dto.name(),
                dto.price(),
                dto.description()
        );

        Product saved = repository.save(product);

        return ProductResponseDto.toDto(saved);
    }

    public ProductResponseDto findProduct(Long productId) {
        Product product = findProductByProductId(productId);

        return ProductResponseDto.toDto(product);
    }

    public List<ProductResponseDto> findProductList() {
        List<Product> productList = repository.findAll();

        return ProductResponseDto.toDto(productList);
    }

    @Transactional
    public ProductResponseDto updateProduct(Long productId, ProductUpdateRequestDto dto) {
        Product product = findProductByProductId(productId);

        String name = resolveValue(dto.name(), product.getName());
        int price = resolveValue(dto.price(), product.getPrice());
        String description = resolveValue(dto.description(), product.getDescription());

        product.update(name, price, description);

        return ProductResponseDto.toDto(product);
    }

    @Transactional
    public void deleteProduct(Long productId) {
        Product product = findProductByProductId(productId);

        repository.delete(product);
    }

    /* ==== Private Helper ==== */
    private Product findProductByProductId(Long productId) {
        return repository.findById(productId)
                .orElseThrow(() -> new IllegalArgumentException("Not Found Product"));
    }

    private <T> T resolveValue(T newValue, T oldValue) {
        return newValue != null ? newValue : oldValue;
    }


}
