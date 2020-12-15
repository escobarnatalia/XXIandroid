/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * @authors  Wilson Suarez, Natalia Escobar, Nicolás Penagos, Valentina Zapata
 * wilsonst.suarez@hotmail.com
 * nataliaescfer@gmail.com
 * nicolas.penagosm98@gmail.com
 * valentinazapataz0306@gmail.com
 **~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package co.natalia.xxiandroid.model;

/*
 * This class will represent each Sale of the Android nodo.
 */

public class Sale {

    // -------------------------------------
    // Atributtes
    // -------------------------------------
    private String address,buyer,id,image,productId,productName,size,total;

    // -------------------------------------
    // Constructors
    // -------------------------------------
    public Sale() {
    }

    public Sale(String address, String buyer, String id, String image, String productId, String productName, String size, String total) {
        this.address = address;
        this.buyer = buyer;
        this.id = id;
        this.image = image;
        this.productId = productId;
        this.productName = productName;
        this.size = size;
        this.total = total;
    }

    // -------------------------------------
    // Getters and setters
    // -------------------------------------
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBuyer() {
        return buyer;
    }

    public void setBuyer(String buyer) {
        this.buyer = buyer;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }
}
