package com.loki.microservices.product.dao;

public record ProductRequest(String id, String name, String description, double price) {
}
