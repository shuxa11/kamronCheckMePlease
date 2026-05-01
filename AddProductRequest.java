package org.example;

public class AddProductRequest {
    private Long orderId;
    private Long productId;
    private int qty;

    public AddProductRequest(Long orderId, Long productId, int qty) {
        this.orderId = orderId;
        this.productId = productId;
        this.qty = qty;
    }

    public Long getOrderId() {
        return orderId;
    }

    public Long getProductId() {
        return productId;
    }

    public int getQty() {
        return qty;
    }
}
