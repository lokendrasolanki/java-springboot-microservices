package com.loki.microservices.product.dao;

public record ProductResponse(String id, String name, String description, double price) {
}
