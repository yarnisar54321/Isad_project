import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.*;

public class InventoryGUI2FX extends Application {

    private TableView<InventoryItem> table;
    private TextField tx, tx2, tx3, tx4;
    private ComboBox<String> tx5;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Inventory Management System");

        // Label สำหรับส่วนหัว
        Label la = new Label("Inventory Management System");
        la.setStyle("-fx-font-size: 20px; -fx-text-fill: white;");

        // การจัดการ TableView
        table = new TableView<>();
        table.setEditable(true);

        TableColumn<InventoryItem, String> idColumn = new TableColumn<>("ID");
        TableColumn<InventoryItem, String> nameColumn = new TableColumn<>("Name");
        TableColumn<InventoryItem, String> quantityColumn = new TableColumn<>("Quantity");
        TableColumn<InventoryItem, String> priceColumn = new TableColumn<>("Price");
        TableColumn<InventoryItem, String> typeColumn = new TableColumn<>("Type");

        table.getColumns().addAll(idColumn, nameColumn, quantityColumn, priceColumn, typeColumn);

        // TextFields and ComboBox สำหรับการกรอกข้อมูล
        tx = new TextField();
        tx.setPromptText("ID");
        tx2 = new TextField();
        tx2.setPromptText("Name");
        tx3 = new TextField();
        tx3.setPromptText("Quantity");
        tx4 = new TextField();
        tx4.setPromptText("Price");

        tx5 = new ComboBox<>();
        tx5.getItems().addAll("Food items", "Beverages", "General merchandise", "Personal care products");
        tx5.setPromptText("Select Type");

        // ปุ่มต่าง ๆ
        Button btAdd = new Button("Add");
        Button btSearch = new Button("Search");
        Button btEdit = new Button("Edit");
        Button btRemove = new Button("Remove");

        btAdd.setOnAction(e -> addItem());
        btEdit.setOnAction(e -> editItem());
        btRemove.setOnAction(e -> removeItem());
        btSearch.setOnAction(e -> searchItem());

        // Layout ของส่วนกรอกข้อมูลและปุ่ม
        GridPane inputPane = new GridPane();
        inputPane.setPadding(new Insets(10));
        inputPane.setHgap(10);
        inputPane.setVgap(10);
        inputPane.add(new Label("ID:"), 0, 0);
        inputPane.add(tx, 1, 0);
        inputPane.add(new Label("Name:"), 0, 1);
        inputPane.add(tx2, 1, 1);
        inputPane.add(new Label("Quantity:"), 0, 2);
        inputPane.add(tx3, 1, 2);
        inputPane.add(new Label("Price:"), 0, 3);
        inputPane.add(tx4, 1, 3);
        inputPane.add(new Label("Type:"), 0, 4);
        inputPane.add(tx5, 1, 4);

        HBox buttonPane = new HBox(10, btAdd, btSearch, btEdit, btRemove);
        buttonPane.setPadding(new Insets(10));

        VBox inputBox = new VBox(10, inputPane, buttonPane);

        // Layout หลัก
        BorderPane root = new BorderPane();
        root.setPadding(new Insets(10));
        root.setTop(la);
        root.setCenter(table);
        root.setBottom(inputBox);
        root.setStyle("-fx-background-color: pink;");

        Scene scene = new Scene(root, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.show();

        loadInventoryFromFile(); // โหลดข้อมูลเมื่อเปิดโปรแกรม
    }

    private void addItem() {
        String id = tx.getText();
        String name = tx2.getText();
        String quantity = tx3.getText();
        String price = tx4.getText();
        String type = tx5.getValue();

        if (!id.isEmpty() && !name.isEmpty() && !quantity.isEmpty() && !price.isEmpty() && type != null) {
            InventoryItem item = new InventoryItem(id, name, Integer.parseInt(quantity), price, type);
            table.getItems().add(item);
            clearTextFields();
            saveInventoryToFile(); // บันทึกข้อมูลเมื่อเพิ่มรายการใหม่
        } else {
            showError("Please fill out all fields.");
        }
    }

    private void editItem() {
        InventoryItem selectedItem = table.getSelectionModel().getSelectedItem();
        if (selectedItem != null) {
            String newName = showInputDialog("Enter new name:");
            String newQuantity = showInputDialog("Enter new quantity:");

            if (newName != null && !newName.isEmpty() && newQuantity != null && !newQuantity.isEmpty()) {
                selectedItem.setName(newName);
                selectedItem.setQuantity(Integer.parseInt(newQuantity));
                saveInventoryToFile(); // บันทึกข้อมูลเมื่อแก้ไข
            }
        } else {
            showError("Please select a row to edit.");
        }
    }

    private void removeItem() {
        InventoryItem selectedItem = table.getSelectionModel().getSelectedItem();
        if (selectedItem != null) {
            table.getItems().remove(selectedItem);
            saveInventoryToFile(); // บันทึกข้อมูลเมื่อรายการถูกลบ
        } else {
            showError("Please select a row to remove.");
        }
    }

    private void searchItem() {
        String searchID = showInputDialog("Enter ID to search:");
        if (searchID != null && !searchID.isEmpty()) {
            boolean found = false;
            for (InventoryItem item : table.getItems()) {
                if (item.getId().equals(searchID)) {
                    table.getSelectionModel().select(item);
                    found = true;
                    break;
                }
            }
            if (!found) {
                showError("ID not found.");
            }
        } else {
            showError("Please enter an ID to search.");
        }
    }

    private void clearTextFields() {
        tx.clear();
        tx2.clear();
        tx3.clear();
        tx4.clear();
        tx5.setValue(null);
    }

    private void showError(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setContentText(message);
        alert.showAndWait();
    }

    private String showInputDialog(String message) {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setHeaderText(null);
        dialog.setContentText(message);
        return dialog.showAndWait().orElse(null);
    }

    private void saveInventoryToFile() {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("inventory.dat"))) {
            for (InventoryItem item : table.getItems()) {
                outputStream.writeObject(item);
            }
        } catch (IOException e) {
            showError("Error saving inventory data.");
        }
    }

    private void loadInventoryFromFile() {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("inventory.dat"))) {
            while (true) {
                try {
                    InventoryItem item = (InventoryItem) inputStream.readObject();
                    table.getItems().add(item);
                } catch (EOFException e) {
                    break;
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            showError("Error loading inventory data.");
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}

class InventoryItem implements Serializable {
    private String id;
    private String name;
    private int quantity;
    private String price;
    private String type;

    public InventoryItem(String id, String name, int quantity, String price, String type) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.type = type;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public int getQuantity() { return quantity; }
    public String getPrice() { return price; }
    public String getType() { return type; }

    public void setName(String name) { this.name = name; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
}