package co.natalia.xxiandroid.model;

import android.util.Log;

public class Product {
private String name,price,productId,quantity,size;

    public Product() {

    }

    public Product(String name, String price, String productId, String quantity, String size) {

        this.name = name;
        this.price = price;
        this.productId = productId;
        this.quantity = quantity;
        this.size = size;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }
}
