package com.accenture.Mapper;

import com.accenture.dto.ProductRequest;
import com.accenture.Entity.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {
    public Product mapToProduct(ProductRequest productRequest){
        return Product.builder()
                .productName(productRequest.getProductName())
                .price(productRequest.getPrice())
                .quantity(productRequest.getQuantity())
                .category(productRequest.getCategory())
                .build();
    }

//    public Response<Product> mapToResponse(Page<Product> pageProduct){

}
