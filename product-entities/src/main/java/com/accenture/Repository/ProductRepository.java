package com.accenture.Repository;

import com.accenture.Entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ProductRepository extends JpaRepository<Product, UUID> {
    Page<Product> findAll(Pageable pageable);
    List<Product> findProductByCategory(String category);

    Optional<Product> findByProductName(String productName);

    Optional<Product> findByProductId(UUID productId);
}
