package org.example;

import java.util.HashMap;
import java.util.Map;


public class ProductRepository {
    private final Map<Long, Product> storage = new HashMap<>();

    public void save(Product product) {
        if (storage.containsKey(product.getId())){
            throw new DuplicateProductException("This product already exists");
        }
        storage.put(product.getId(), product);
    }

    public Product findById(Long id) {
        Product product = storage.get(id);
        if (product == null) {
            throw new ProductNotFoundException("Product not found");
        }
        return product;
    }
}
