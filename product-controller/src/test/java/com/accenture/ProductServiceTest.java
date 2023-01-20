package com.accenture;

import com.accenture.Entity.Product;
import com.accenture.Repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;
import java.util.UUID;

import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
 class ProductServiceTest {

   @Mock
   private ProductRepository productRepository;

   @InjectMocks
   private ProductServiceImpl productService;
   
   private Product product;

    @BeforeEach
    public void setup(){
        product = Product.builder()
                .productId(UUID.randomUUID())
                .productName("Fish")
                .price(100L)
                .quantity(2)
                .build();
    }

    // JUnit test for getProductByName method
    @DisplayName("JUnit test for getProductByName method")
    @Test
    void givenProductName_whenGetProductByName_thenReturnProduct() throws ProductNotFoundException {
        // given
        given(productRepository.findByProductName("Fish")).willReturn(Optional.of(product));

        // when
        Product savedProduct = productService.getProductByName(product.getProductName()).get();

        // then
        assertThat(savedProduct).isNotNull();

    }
}
