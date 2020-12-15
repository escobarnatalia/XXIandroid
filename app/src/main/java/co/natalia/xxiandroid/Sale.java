package co.natalia.xxiandroid;

public class Sale {
    private String address,buyer,id,image,productId,productName,size,total;

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
