package shuxa.project.Order;

public class OrderCreateRequest {
    private Long orderId;
    private Long userId;

    public OrderCreateRequest(Long orderId, Long userId) {
        this.orderId = orderId;
        this.userId = userId;
    }

    public Long getOrderId() {
        return orderId;
    }
    public Long getUserId() {
        return userId;
    }

}
