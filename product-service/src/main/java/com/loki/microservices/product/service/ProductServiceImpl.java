package com.loki.microservices.product.service;

import com.loki.microservices.product.dao.ProductRequest;
import com.loki.microservices.product.dao.ProductResponse;
import com.loki.microservices.product.model.Product;
import com.loki.microservices.product.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class ProductServiceImpl implements  ProductService{


    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product createProduct(ProductRequest productRequest) {
        Product product = Product.builder()
                .name(productRequest.name())
                .description(productRequest.description())
                .price(productRequest.price())
                .build();

        productRepository.save(product);
        log.info("Product {} is saved", product.getName());
        return product;
    }

    @Override
    public List<ProductResponse> getAllProducts() {
List<Product> products = productRepository.findAll();
        return products.stream().map(product -> new ProductResponse(product.getId(), product.getName(), product.getDescription(), product.getPrice()))
                .toList();
    }
}
