package testDatabase;
import proj.InventoryItem;

import java.io.*;
import java.sql.*;

public class datConvertToDB {
    dbConnect db = new dbConnect();
    //InventoryItem has String id, String name, int quantity, String price, String type
    public datConvertToDB() { 
        db.connect();
        String sqlReset = "TRUNCATE TABLE inventory;";
        db.getUpdate(sqlReset);
        try (FileInputStream fileIn = new FileInputStream("inventory.dat");
             ObjectInputStream inputStream = new ObjectInputStream(fileIn)) {
            while (true) {
                try {
                    InventoryItem item = (InventoryItem) inputStream.readObject();
                    String id = item.getId();
                    String name = item.getName();
                    int quantity = item.getQuantity();
                    String price = item.getPrice();
                    String type = item.getType();
                    System.out.println(id+name+quantity+price+type);

                    String sql = String.format("INSERT INTO `inv`.`inventory`(`productID`,`productName`,`productQuantity`,`productPrice`,`productType`) VALUES('%s', '%s', '%d', '%s', '%s')", id, name, quantity, price, type);
                    db.getUpdate(sql);
                    System.out.print("|");
                } catch (EOFException einputStream) {
                    break;
                }
            }
            db.disconnect();
            inputStream.close();
        } catch (IOException|ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        new datConvertToDB();
    }
}
