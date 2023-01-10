package com.accenture;

import DTO.ProductRequest;
import com.accenture.Entity.Category;
import com.accenture.Entity.Product;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class ProductServiceImpl implements ProductService{
    @Override
    public List<Product> fetchProduct() {
        return null;
    }

    @Override
    public Optional<Product> getProductById(UUID monitorId) {
        return Optional.empty();
    }

    @Override
    public Product saveProduct(ProductRequest productRequest) {
        return null;
    }

    @Override
    public Product updateProduct(UUID productId, ProductRequest productRequest) {
        return null;
    }

    @Override
    public void deleteProductById(UUID productId) {

    }

    @Override
    public List<Product> getProductByCategory(Category category) {
        return null;
    }
}
