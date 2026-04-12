package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Order {
    private Long id;
    private User user;
    private List<Product> products = new ArrayList<>();


    public Order(Long id, User user) {
        if(user == null){
            throw new IllegalArgumentException("User cannot be null");
        }
        this.id = id;
        this.user = user;
    }

    public List<Product> getProducts(){
        return Collections.unmodifiableList(products);
    }



    public void addProduct(Product product) {
        if(product == null){
            throw new IllegalArgumentException("Product cannot be null");
        }
        products.add(product);
    }

    public void removeProduct(Product product) {
        if(product == null){
            throw new IllegalArgumentException("Product cannot be null");
        }
        if(!products.remove(product)){
            throw new IllegalArgumentException("Product not found");
        }
    }
    


    public double getTotalPrice(){
        double total = 0.0;
        for(Product product: products){
            total += product.getPrice();
        }
        return total;
    }

    public int getProductCount(){
        return products.size();
    }

    @Override
    public String toString() {
        return "Order{id=" + id +
                ", user=" + user.getName() +
                ", products=" + products.size() +
                ", total=" + getTotalPrice() +
                '}';
    }


}
