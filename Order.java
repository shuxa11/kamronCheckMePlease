package org.example;

import java.util.*;

public class Order {
    private Long id;
    private User user;
    private Map<Product, Integer> productCounts = new HashMap<>();
    private OrderStatus status;

    public Order(Long id, User user) {
        if(user == null){
            throw new IllegalArgumentException("User can not be null");
        }
        this.id = id;
        this.user = user;
        this.status = OrderStatus.NEW;
    }

    public Map<Product, Integer> getProducts(){
        return Collections.unmodifiableMap(productCounts);
    }

    public OrderStatus getStatus(){
        return status;
    }

    public void setStatus(OrderStatus status){
        if(this.status == OrderStatus.NEW && status != OrderStatus.NEW){
            this.status = status;
        }
        if(this.status != OrderStatus.NEW){
            throw new InvalidOrderStateException("Can not modify finalized order's state");
        }

    }

    public void addProduct(Product product, int qty) {
        if(status != OrderStatus.NEW){
            throw new InvalidOrderStateException("Can not modify finalized order");
        }
        if(product == null){
            throw new IllegalArgumentException("Product cannot be null");
        }
        if(qty <= 0){
            throw new IllegalArgumentException("Quantity cannot be negative");
        }
        productCounts.put(product, productCounts.getOrDefault(product, 0) + qty);
    }

    public void removeProduct(Product product,int count) {
        if(product == null){
            throw new IllegalArgumentException("Product cannot be null");
        }
        if(count <= 0){
            throw new IllegalArgumentException("Quantity should be positive");
        }
        if(!productCounts.containsKey(product)){
            throw new ProductNotFoundException("Product not found");
        }

        Integer prCount = productCounts.get(product);

        if(prCount < count ){
            throw new IllegalArgumentException("in the order there is less products than you asked to remove");
        }
        if(prCount - count == 0){
            productCounts.remove(product);
        }else{
            productCounts.put(product, productCounts.get(product) - count);
        }
    }



    public double getTotalPrice() {
        double total = 0.0;

        for (Map.Entry<Product, Integer> entry : productCounts.entrySet()) {
            total += entry.getKey().getPrice() * entry.getValue();
        }

        return total;
    }

    public int getProductCount(){
        int total = 0;
        for (int count: productCounts.values()){
            total += count;
        }
        return total;
    }

    @Override
    public String toString() {
        return "Order{id=" + id +
                ", user=" + user.getName() +
                ", products=" + getProductCount() +
                ", total=" + getTotalPrice() +
                '}';
    }


}
