package shuxa.project;

import shuxa.project.Order.*;
import shuxa.project.User.*;
import shuxa.project.Exceptions.*;
import shuxa.project.Product.*;
import shuxa.project.Admin.*;


public class Main {
   public static void main(String[] args) {
      User user = new User(111L, "shuxa", "saka@gmail.com");

      OrderRepository orderRepo = new OrderRepository();
      ProductRepository productRepo = new ProductRepository();
      UserRepository userRepo = new UserRepository();
      OrderService service = new OrderService(orderRepo, productRepo, userRepo);
      Product p1 = new Product(1L, "Laptop", 1200.0);
      Product p2 = new Product(2L, "Mouse", 25.0);
      Product p3= new Product(3L, "Keyboard", 75.0);
      Product p4 = new Product(4L, "Monitor", 300.0);

      userRepo.save(user);
      productRepo.save(p1);
      productRepo.save(p2);
      productRepo.save(p3);
      productRepo.save(p4);

      OrderController controller = new OrderController(service);

      controller.createOrder(new OrderCreateRequest(1L, 111L));
      controller.createOrder(new OrderCreateRequest(2L, 111L));

      controller.addProduct(new AddProductRequest(1L, 2L, 5));
      controller.addProduct(new AddProductRequest(1L, 1L, 15));
      controller.addProduct(new AddProductRequest(2L, 2L, 15));

      controller.removeProduct(new RemoveProductRequest(1L, 2L, 2));

      double total = controller.checkout(1L);

      System.out.println("Paid: " + total);
   }
}