package entity;
import java.util.UUID;

public class Product {



    private UUID id;
    private String name;
    private float price;
    private int quantity;
    private int discount;

    public Product() {
    }

    public UUID getId() {
        return id;
    }



    public void setId(UUID id) {
        this.id = this.id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }
}
