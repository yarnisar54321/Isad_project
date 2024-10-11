package javafxapplication1;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import java.io.Serializable;

public class InventoryItem implements Serializable {
    
    private final SimpleStringProperty id;
    private final SimpleStringProperty name;
    private final SimpleIntegerProperty quantity;
    private final SimpleStringProperty price;
    private final SimpleStringProperty type;

    // Constructor
    public InventoryItem(String id, String name, int quantity, String price, String type) {
        this.id = new SimpleStringProperty(id);
        this.name = new SimpleStringProperty(name);
        this.quantity = new SimpleIntegerProperty(quantity);
        this.price = new SimpleStringProperty(price);
        this.type = new SimpleStringProperty(type);
    }

    // Getters and Setters using JavaFX properties
    public String getId() {
        return id.get();
    }

    public void setId(String id) {
        this.id.set(id);
    }

    public String getName() {
        return name.get();
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public int getQuantity() {
        return quantity.get();
    }

    public void setQuantity(int quantity) {
        this.quantity.set(quantity);
    }

    public String getPrice() {
        return price.get();
    }

    public void setPrice(String price) {
        this.price.set(price);
    }

    public String getType() {
        return type.get();
    }

    public void setType(String type) {
        this.type.set(type);
    }

    // Property methods for binding
    public SimpleStringProperty idProperty() {
        return id;
    }

    public SimpleStringProperty nameProperty() {
        return name;
    }

    public SimpleIntegerProperty quantityProperty() {
        return quantity;
    }

    public SimpleStringProperty priceProperty() {
        return price;
    }

    public SimpleStringProperty typeProperty() {
        return type;
    }
}
