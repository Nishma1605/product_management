package com.accenture;

import com.accenture.dto.ProductRequest;
import com.accenture.dto.ProductUpdate;
import com.accenture.dto.Response;
import com.accenture.Entity.Product;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProductService {
    Response<Product> fetchProduct(int page, int size);

    List<Product> fetchProductPrice();

    Product getProductById(UUID productId) throws ProductNotFoundException;

    Optional<Product> getProductByName(String productName);

    Product saveProduct(ProductRequest productRequest);

    Product updateProduct(UUID productId, ProductUpdate productUpdate) throws ProductNotFoundException;

    void deleteProductById(UUID productId) throws ProductNotFoundException;

    List<Product> getProductByCategory(String category);

}
