package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        User user = new User(111L, "shuxa", "saka@gmail.com");
        Admin admin = new Admin(222L, "pipang admin", "pipang@gmail.com");

        Product p1 = new Product(1L, "Laptop", 1200.0);
        Product p2 = new Product(2L, "Mouse", 25.0);
        Product p3 = new Product(3L, "Keyboard", 75.0);
        Product p4 = new Product(4L, "Monitor", 300.0);

        Order order = new Order(1L, user);

        order.addProduct(p1);
        order.addProduct(p2);
        order.addProduct(p3);
        order.addProduct(p4);

        try{
            order.addProduct(null);
        }catch (IllegalArgumentException e){
            System.out.println("Pass: null rejected -> " + e.getMessage());
        }

        try {
            order.removeProduct(p1);
        } catch (Exception e) {
            System.out.println("PASS: remove non-existing product");
        }

        try {
            new User(1L, "", "mail");
        } catch (Exception e) {
            System.out.println("PASS: invalid user name");
        }

        try {
            new Product(1L, "Test", 0);
        } catch (Exception e) {
            System.out.println("PASS: invalid price");
        }


        System.out.println("Total price: " + order.getTotalPrice());
        System.out.println("Product count: " + order.getProductCount());

        order.removeProduct(p2);

        System.out.println("***********************");
        System.out.println("Total price: " + order.getTotalPrice());
        System.out.println("Product count: " + order.getProductCount());


    }
}