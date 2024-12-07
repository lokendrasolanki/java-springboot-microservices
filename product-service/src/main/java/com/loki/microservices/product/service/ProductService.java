package com.loki.microservices.product.service;

import com.loki.microservices.product.dao.ProductRequest;
import com.loki.microservices.product.dao.ProductResponse;
import com.loki.microservices.product.model.Product;

import java.util.List;

public interface ProductService {
    Product createProduct(ProductRequest productRequest);
    List<ProductResponse> getAllProducts();

}
