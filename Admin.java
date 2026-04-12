package org.example;

import java.util.List;

public class Admin extends User{
    public Admin(Long id, String name, String email) {
        super(id, name, email);
    }

    void printAllOrders(List<Order> orders){
        for(Order order: orders){
            order.toString();
        }
    }
}
