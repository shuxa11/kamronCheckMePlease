package org.example;

public class OrderService {
    public Order createOrder(Long id, User user) {
        if(user == null){
            throw new IllegalArgumentException("User can not be null");
        }
        return new Order(id, user);
    }

    public void addProduct(Order order, Product product, int qty){
        if (product == null || qty <= 0) {
            throw new IllegalArgumentException("Invalid product or quantity");
        }else {
            order.addProduct(product, qty);
        }
    }

    public void removeProduct(Order order, Product product, int qty){
        if (product == null || qty <= 0) {
            throw new IllegalArgumentException("Invalid product or quantity");
        }
        if (order.getStatus() != OrderStatus.NEW){
            throw new InvalidOrderStateException("This order is already paid or cancelled");
        }else {
            order.removeProduct(product, qty);
        }
    }

    public double checkout(Order order){
        if (order.getStatus() != OrderStatus.NEW){
            throw new InvalidOrderStateException("This order is already paid or cancelled");
        }
        if(order.getProducts().isEmpty()){
            throw new EmptyOrderException("This order is empty");
        }else {
            order.setStatus(OrderStatus.PAID);
            return order.getTotalPrice();
        }
    }

    public void cancel(Order order){
        if (order.getStatus() != OrderStatus.NEW){
            throw new InvalidOrderStateException("This order is already paid or cancelled");
        }else {
            order.setStatus(OrderStatus.CANCELLED);
        }
    }


}
