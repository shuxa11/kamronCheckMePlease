package org.example;

import java.util.*;

public class Order {
    private Long id;
    private User user;
    private Map<Product, Integer> productCounts = new HashMap<>();


    public Order(Long id, User user) {
        if(user == null){
            throw new IllegalArgumentException("User cannot be null");
        }
        this.id = id;
        this.user = user;
    }

    public Map<Product, Integer> getProducts(){
        return Collections.unmodifiableMap(productCounts);
    }



    public void addProduct(Product product) {
        if(product == null){
            throw new IllegalArgumentException("Product cannot be null");
        }
        productCounts.put(product, productCounts.getOrDefault(product, 0) + 1);
    }

    public void removeProduct(Product product,int count) {
        if(product == null){
            throw new IllegalArgumentException("Product cannot be null");
        }
        if(count <= 0){
            throw new IllegalArgumentException("Quantity cannot be less than zero");
        }
        if(!productCounts.containsKey(product)){
            throw new IllegalArgumentException("Product not found");
        }

        Integer prCount = productCounts.get(product);

        if(prCount < count ){
            throw new IllegalArgumentException("in the order there is less amount of products than you asked to remove");
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
