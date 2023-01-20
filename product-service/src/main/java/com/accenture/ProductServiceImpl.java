package com.accenture;

import com.accenture.dto.ProductRequest;
import com.accenture.dto.ProductUpdate;
import com.accenture.dto.Response;
import com.accenture.Mapper.ProductMapper;
import com.accenture.Repository.ProductRepository;
import com.accenture.Entity.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    private final ProductMapper productMapper;

    @Override
    public Response<Product> fetchProduct(int page, int size) {
        Page<Product> products = productRepository.findAll(PageRequest.of(page - 1, size));
        return new Response<>(page, size, products.getTotalElements(), products.getTotalPages(), products.getContent());
    }

    @Override
    public List<Product> fetchProductPrice() {

        return productRepository.findAll(Sort.by(Sort.Direction.ASC, "price"));
    }

    @Override
    public Product getProductById(UUID productId) throws ProductNotFoundException {

        return productRepository.findByProductId(productId).orElseThrow(
                () -> new ProductNotFoundException("Product does not exist with this ID " + productId));
    }

    @Override
    public Optional<Product> getProductByName(String productName) {
        return productRepository.findByProductName(productName);
    }

    @Override
    public Product saveProduct(ProductRequest productRequest) {
        return productRepository.save(this.productMapper.mapToProduct(productRequest));
    }

    @Override
    public Product updateProduct(UUID productId, ProductUpdate productUpdate) throws ProductNotFoundException {
        Product productDB = productRepository.findByProductId(productId).orElseThrow(
                () -> new ProductNotFoundException("Product does not exist with this ID " + productId)
        );

        productDB.setProductName(productUpdate.getProductName());
        productDB.setPrice(productUpdate.getPrice());
        productDB.setCategory(productUpdate.getCategory());
        productDB.setQuantity(productUpdate.getQuantity());

        return productRepository.save(productDB);
    }

    @Override
    public void deleteProductById(UUID productId) throws ProductNotFoundException {
        productRepository.findByProductId(productId).orElseThrow(
                () -> new ProductNotFoundException("Product does not exist with this ID" + productId));
    }

    @Override
    public List<Product> getProductByCategory(String category) {
        return productRepository.findProductByCategory(category);

    }
}
