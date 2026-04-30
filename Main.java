package org.example;

public class Main {
   public static void main(String[] args) {
      User user = new User(111L, "shuxa", "saka@gmail.com");

      OrderRepository orderRepo = new OrderRepository();
      ProductRepository productRepo = new ProductRepository();
      UserRepository userRepo = new UserRepository();
      OrderService service = new OrderService(orderRepo, productRepo, userRepo);
      Product p1 = new Product(1L, "Laptop", 1200.0);
      Product p2 = new Product(2L, "Mouse", 25.0);
      Product p3 = new Product(3L, "Keyboard", 75.0);
      Product p4 = new Product(4L, "Monitor", 300.0);

      userRepo.save(user);
      productRepo.save(p1);
      productRepo.save(p2);
      productRepo.save(p3);
      productRepo.save(p4);

      Order order = service.createOrder(1L, 111L);
      Order order1 = service.createOrder(2L, 111L);

      service.addProduct(1L, 2L, 5);
      service.addProduct(1L, 1L, 15);
      service.addProduct(2L, 2L, 15);

      double total = service.checkout(2L);
      System.out.println("Paid: " + total);
   }
}