/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * @authors  Wilson Suarez, Natalia Escobar, Nicolás Penagos, Valentina Zapata
 * wilsonst.suarez@hotmail.com
 * nataliaescfer@gmail.com
 * nicolas.penagosm98@gmail.com
 * valentinazapataz0306@gmail.com
 **~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package co.natalia.xxiandroid.model;

import android.util.Log;

/*
 * This class will represent each Product of the Android nodo.
 */

public class Product {

    // -------------------------------------
    // Atributtes
    // -------------------------------------

    private String name,price,productId,quantity,size;

    // -------------------------------------
    // Constructors
    // -------------------------------------
    public Product() {

    }

    public Product(String name, String price, String productId, String quantity, String size) {

        this.name = name;
        this.price = price;
        this.productId = productId;
        this.quantity = quantity;
        this.size = size;

    }

    // -------------------------------------
    // Getters and setters
    // -------------------------------------
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
