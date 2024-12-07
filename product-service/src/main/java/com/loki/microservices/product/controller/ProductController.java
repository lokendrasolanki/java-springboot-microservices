package com.loki.microservices.product.controller;

import com.loki.microservices.product.dao.ProductRequest;
import com.loki.microservices.product.dao.ProductResponse;
import com.loki.microservices.product.model.Product;
import com.loki.microservices.product.repository.ProductRepository;
import com.loki.microservices.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/product/")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductService productService;

    /**
     * Creates a new product and returns the created product.
     *
     * @param productRequest the product to create
     * @return the created product
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Product createProduct(@RequestBody ProductRequest productRequest) {

        return productService.createProduct(productRequest);
    }


    /**
     * Gets all products.
     *
     * @return all products
     */
    @GetMapping("{product_id}")
    public List<ProductResponse> getProduct(@PathVariable String product_id) {

    return productService.getAllProducts();
    }

}
