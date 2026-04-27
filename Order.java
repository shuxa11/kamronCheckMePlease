package org.example;

import java.util.*;

public class Order {
    private final Long id;
    private final User user;
    private List<OrderItem> items = new ArrayList<>();
    private OrderStatus status;

    public Order(Long id, User user) {
        if(user == null){
            throw new IllegalArgumentException("User can not be null");
        }
        this.id = id;
        this.user = user;
        this.status = OrderStatus.NEW;
    }

    public List<OrderItem> getItems(){
        return Collections.unmodifiableList(items);
    }

    public OrderStatus getStatus(){
        return status;
    }

    public void markPaid(){
        if(this.status != OrderStatus.NEW){
            throw new InvalidOrderStateException("Order already finalized ");
        }
        this.status = OrderStatus.PAID;
    }

    public void cancel(){
        if(this.status != OrderStatus.NEW){
            throw new InvalidOrderStateException("Order already finalized");
        }
        this.status = OrderStatus.CANCELLED;
    }

    public void addProduct(Product product, int qty) {
        if(this.status != OrderStatus.NEW){
            throw new InvalidOrderStateException("Can not modify finalized order");
        }
        if(product == null){
            throw new IllegalArgumentException("Product cannot be null");
        }
        if(qty <= 0){
            throw new IllegalArgumentException("Quantity should be positive");
        }
        for(OrderItem item : items){
            if(item.getPriceAtPurchase() == product.getPrice() && item.getProduct().equals(product)){
                item.increaseQty(qty);
                return;
            }

        }
        items.add(new OrderItem(product, qty));

    }

    public void removeProduct(Product product,int count) {
        if(this.status != OrderStatus.NEW){
            throw new InvalidOrderStateException("Can not modify finalized order");
        }
        if(product == null){
            throw new IllegalArgumentException("Product cannot be null");
        }
        if(count <= 0){
            throw new IllegalArgumentException("Quantity should be positive");
        }

        Iterator<OrderItem> it = items.iterator();

        while (it.hasNext()){
            OrderItem item = it.next();

            if (item.getPriceAtPurchase() == product.getPrice() &&
                    item.getProduct().equals(product)){
                if (item.getQty() < count){
                    throw new IllegalArgumentException("Not enough quantity of product");
                }

                item.decreaseQty(count);

                if (item.getQty() == 0) {
                    it.remove();
                }

                return;
            }
        }

        throw new ProductNotFoundException("Product not found");

    }

    public int getProductCount(){
        int total = 0;
        for (OrderItem item: items){
            total += item.getQty();
        }
        return total;
    }

    public double getTotalPrice(){
        double total = 0;
        for (OrderItem item: items){
            total += item.getPriceAtPurchase() * item.getQty();
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
