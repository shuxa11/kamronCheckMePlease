package shuxa.project.Order;


import shuxa.project.Product.*;

public class OrderItem {
    private final Long productId;
    private final String productName;
    private int qty;
    private final double priceAtPurchase;

    public Long getProductId(){
        return this.productId;
    }
    public double getPriceAtPurchase(){
        return this.priceAtPurchase;
    }
    public String getProductName(){
        return this.productName;
    }
    public int getQty(){
        return this.qty;
    }

    public OrderItem(Product product, int qty){
        if (product == null){
            throw new IllegalArgumentException("Product can not be null");
        }
        if (qty <= 0){
            throw new IllegalArgumentException("Quantity must be positive");
        }
        this.productId = product.getId();
        this.productName = product.getName();
        this.qty = qty;
        this.priceAtPurchase = product.getPrice();
    }
    public void increaseQty(int qty){
        this.qty += qty;
    }
    public void decreaseQty(int qty){
        if(this.qty < qty){
            throw new IllegalArgumentException("You can not remove more products than it exists in the order");
        }
        this.qty -= qty;
    }
    public double getTotalPrice(){
        return priceAtPurchase * qty;
    }

}
