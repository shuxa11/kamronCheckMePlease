package org.example;

public class OrderItem {
    private final Product product;
    private int qty;
    private final double priceAtPurchase;

    public Product  getProduct(){
        return this.product;
    }
    public double getPriceAtPurchase(){
        return this.priceAtPurchase;
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
        this.product = product;
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
