package com.accenture;

import DTO.ProductRequest;
import com.accenture.Entity.Category;
import com.accenture.Entity.Product;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProductService {
    List<Product> fetchProduct();

    Optional<Product> getProductById(UUID monitorId);

    Product saveProduct(ProductRequest productRequest);

    Product updateProduct(UUID productId,ProductRequest productRequest);

    void deleteProductById(UUID productId);

    List<Product> getProductByCategory(Category category);
}
