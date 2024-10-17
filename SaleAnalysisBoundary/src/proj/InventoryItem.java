package proj;

import java.io.Serializable;

public class InventoryItem implements Serializable {
    private String id;
    private String name;
    private String price;
    private String type;
    private int quantity; 

    public InventoryItem(String id, String name, int quantity, String price, String type) { 
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getQuantity() { 
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}