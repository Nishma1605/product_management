package com.accenture;

import com.accenture.Entity.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/products")
public class ProductController {

    private final ProductService productService;

    @GetMapping()
    public List<Product> Product(){
        return productService.fetchProduct();
    }

    @GetMapping("/{id}")
    public Optional<Product> getProductById(@PathVariable("id") UUID productId){
        return productService.getProductById(productId);
    }
}
