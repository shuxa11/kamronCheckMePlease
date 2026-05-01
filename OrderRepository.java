package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderRepository {
    private final Map<Long, Order> storage = new HashMap<>();

    public void save(Order order) {
        if (storage.containsKey(order.getId())){
                throw new DuplicateOrderException("This order already exists");
        }
        storage.put(order.getId(), order);
    }

    public Order findById(Long id) {
        Order order = storage.get(id);
        if (order == null) {
            throw new OrderNotFoundException("Order not found");
        }
        return order;
    }

    public List<Order> findAll() {
        return new ArrayList<>(storage.values());
    }

    public void delete(Long id) {
        if(!storage.containsKey(id)){
            throw new OrderNotFoundException("Order not found");
        }
        storage.remove(id);
    }
}
