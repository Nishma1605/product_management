package com.accenture;

import com.accenture.dto.ProductRequest;
import com.accenture.dto.ProductUpdate;
import com.accenture.dto.Response;
import com.accenture.Entity.Product;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/products")
public class ProductController {

    private final ProductService productService;

    @Operation(summary = "Get all products",description = "Fetch all products", tags = "product-entity-controller")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "product fetched",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Product.class))}),
            @ApiResponse(responseCode = "404", description = "product not fetched",
                    content = @Content)
    })
    @GetMapping()
    public Response<Product> Product(@RequestParam(required = false,defaultValue = "1") int page,
                                     @RequestParam(required = false,defaultValue = "4") int size){

        return productService.fetchProduct(page, size);
    }

    @Operation(summary = "Fetch product by ID",description = "Fetch a product by ID", tags = "product-entity-controller")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "product fetched by ID",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Product.class))}),
            @ApiResponse(responseCode = "404", description = "product not fetched by ID",
                    content = @Content)
    })
    @GetMapping("/productId/{productId}")
    public Product getProductById(@PathVariable("productId") UUID productId) throws ProductNotFoundException{
        return productService.getProductById(productId);
    }

    @Operation(summary = "Fetch product by name",description = "Fetch a product by name", tags = "product-entity-controller")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "product fetched by name",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Product.class))}),
            @ApiResponse(responseCode = "404", description = "product not fetched by name",
                    content = @Content)
    })
    @GetMapping("/product-name/{productName}")
    public Optional<Product> getProductByName(@PathVariable("productName") String productName){
        return productService.getProductByName(productName);
    }

    @Operation(summary = "Fetch product by price",description = "Fetch a product by price", tags = "product-entity-controller")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "product fetched by price",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Product.class))}),
            @ApiResponse(responseCode = "404", description = "product not fetched by price",
                    content = @Content)
    })
    @GetMapping("/productPrice")
    public List<Product> getProductPrice () {

        return productService.fetchProductPrice();
    }

    @Operation(summary = "Fetch product by category",description = "Fetch a product by category", tags = "product-entity-controller")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "product fetched by category",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Product.class))}),
            @ApiResponse(responseCode = "404", description = "product not fetched by category",
                    content = @Content)
    })
    @GetMapping("/productCategory/{productCategory}")
    public List<Product> getProductByCategory (@PathVariable("productCategory") String category) {
        return productService.getProductByCategory(category);
    }

    @Operation(summary = "Save product",description = "Save a new product", tags = "product-entity-controller")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "product saved",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Product.class))}),
            @ApiResponse(responseCode = "404", description = "product not saved",
                    content = @Content)
    })
    @PostMapping()
    public Product saveProduct(@Valid @RequestBody ProductRequest productRequest) {
        return productService.saveProduct(productRequest);
    }

    @Operation(summary = "Update product by ID",description = "Update a product by ID", tags = "product-entity-controller")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "product updated by ID",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Product.class))}),
            @ApiResponse(responseCode = "404", description = "product not updated by ID",
                    content = @Content)
    })
    @PutMapping("/{productId}")
    public Product updateProduct(@Valid @PathVariable("productId") UUID productId,
                                 @RequestBody ProductUpdate productUpdate) throws ProductNotFoundException{
        return productService.updateProduct(productId, productUpdate);
    }

    @Operation(summary = "Delete product by ID",description = "Delete a product by ID", tags = "product-entity-controller")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "product deleted by ID",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Product.class))}),
            @ApiResponse(responseCode = "404", description = "product not deleted by ID",
                    content = @Content)
    })
    @DeleteMapping("/{productId}")
    public String deleteProductById(@PathVariable("productId") UUID productId) throws ProductNotFoundException{
        productService.deleteProductById(productId);
        return "Product deleted successfully!";
    }
}
