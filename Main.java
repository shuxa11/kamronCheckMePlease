package org.example;

public class Main {
     public static void main(String[] args) {
        User user = new User(111L, "shuxa", "saka@gmail.com");
        Admin admin = new Admin(222L, "pipang admin", "pipang@gmail.com");

        OrderService service = new OrderService();
        Product p1 = new Product(1L, "Laptop", 1200.0);
        Product p2 = new Product(2L, "Mouse", 25.0);
        Product p3 = new Product(3L, "Keyboard", 75.0);
        Product p4 = new Product(4L, "Monitor", 300.0);

        Order order = service.createOrder(1L, user);
        Order order1 = service.createOrder(2L, user);

        service.addProduct(order, p3, 5);
        service.addProduct(order, p1, 12);
        service.addProduct(order1, p2, 15);

        double total = service.checkout(order);
        System.out.println("Paid: " + total);




//        Product p1 = new Product(1L, "Laptop", 1200.0);
//        Product p2 = new Product(2L, "Mouse", 25.0);
//        Product p3 = new Product(3L, "Keyboard", 75.0);
//        Product p4 = new Product(4L, "Monitor", 300.0);
//
//        Order order = new Order(1L, user);

//        order.addProduct(p1);
//        order.addProduct(p2);
//        order.addProduct(p3);
//        order.addProduct(p3);
//        order.addProduct(p3);
//        order.addProduct(p3);
//        order.addProduct(p3);
//        order.addProduct(p4);

//        try{
//            order.addProduct(null);
//        }catch (IllegalArgumentException e){
//            System.out.println("Pass: null rejected -> " + e.getMessage());
//        }
//
//        try {
//            order.removeProduct(p1, 1);
//        } catch (Exception e) {
//            System.out.println("PASS: remove non-existing product");
//        }
//
//        try {
//            new User(1L, "", "mail");
//        } catch (Exception e) {
//            System.out.println("PASS: invalid user name");
//        }
//
//        try {
//            new Product(1L, "Test", 0);
//        } catch (Exception e) {
//            System.out.println("PASS: invalid price");
//        }


//        System.out.println("Total price: " + order.getTotalPrice());
//        System.out.println("Product count: " + order.getProductCount());
//
//        order.removeProduct(p3, 1);
//
//        System.out.println("***********************");
//        System.out.println("Total price: " + order.getTotalPrice());
//        System.out.println("Product count: " + order.getProductCount());


    }
}