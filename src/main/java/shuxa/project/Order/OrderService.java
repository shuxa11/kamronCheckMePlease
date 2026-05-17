package shuxa.project.Order;

import shuxa.project.Product.*;
import shuxa.project.User.*;
import shuxa.project.Exceptions.*;

public class OrderService {
    private final OrderRepository orderRepo;
    private final ProductRepository productRepo;
    private final UserRepository userRepo;

    public OrderService(OrderRepository orderRepo,
                        ProductRepository productRepo,
                        UserRepository userRepo){
        this.orderRepo = orderRepo;
        this.productRepo = productRepo;
        this.userRepo = userRepo;
    }

    public Order createOrder(Long id, Long userId){
        User user = userRepo.findById(userId);
        Order order = new Order(id, user);
        orderRepo.save(order);
        return order;
    }
    public void addProduct(Long orderId, Long productId, int qty){
        Order order = orderRepo.findById(orderId);
        Product product = productRepo.findById(productId);
        order.addProduct(product, qty);
    }

    public void removeProduct(Long orderId, Long productId, int qty){
        Order order = orderRepo.findById(orderId);
        Product product = productRepo.findById(productId);

        order.removeProduct(product, qty);
    }

    public double checkout(Long orderId){
        Order order = orderRepo.findById(orderId);
        if(order == null){
            throw new OrderNotFoundException("Order not found");
        }
        if(order.getStatus() != OrderStatus.NEW){
            throw new InvalidOrderStateException("Can not modify finalized order");
        }
        order.markPaid();
        return order.getTotalPrice();
    }

    public void cancel(Long orderId){
        Order order = orderRepo.findById(orderId);
        order.cancel();
    }


}
