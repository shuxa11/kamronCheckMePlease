package org.example;

public class OrderController {
    private final OrderService service;

    public OrderController(OrderService service){
        this.service = service;
    }

    public void createOrder(OrderCreateRequest request){
        service.createOrder(request.getOrderId(), request.getUserId());
    }

    public void addProduct(AddProductRequest request){
        service.addProduct(request.getOrderId(),
                request.getProductId(), request.getQty());
    }

    public void removeProduct(RemoveProductRequest request){
        service.removeProduct(request.getOrderId(),
                request.getProductId(), request.getQty());
    }

    public double checkout(Long orderId){
        return service.checkout(orderId);
    }

}
