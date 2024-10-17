package testDatabase;

import proj.InventoryItem;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.*;
import java.sql.*;

public class InventoryGUI2_DB {
    private JFrame fr;
    private JPanel pl, pl2, pl3, pl4, pl5, pl7;
    private JButton bt, bt2, bt3, bt4;
    private JLabel la, la2, la3, la4, la5, la6;
    private JTextField tx, tx2, tx3, tx4;
    private JComboBox<String> tx5;
    private DefaultTableModel tableModel;
    private JTable table;
    private dbConnect db;

    public InventoryGUI2_DB() {
        fr = new JFrame("Inventory");
        pl = new JPanel();
        pl2 = new JPanel();
        pl3 = new JPanel();
        pl4 = new JPanel();
        pl5 = new JPanel();
        pl7 = new JPanel();
        bt = new JButton("Add");
        bt2 = new JButton("Search");
        bt3 = new JButton("Edit");
        bt4 = new JButton("Remove");
        la = new JLabel("Inventory Management System");
        la2 = new JLabel("ID");
        la3 = new JLabel("Name");
        la4 = new JLabel("Quantity");
        la5 = new JLabel("Price");
        la6 = new JLabel("Type");
        tx = new JTextField(10);
        tx2 = new JTextField(10);
        tx3 = new JTextField(10);
        tx4 = new JTextField(10);
        tx5 = new JComboBox<>(new String[]{"Food items", "Beverages", "General merchandise", "Personal care products"});

        fr.setLayout(new BorderLayout());
        fr.setVisible(true);
        fr.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        fr.setSize(650, 400);

        pl.setLayout(new BorderLayout());
        pl.add(pl2, BorderLayout.NORTH);

        pl2.setLayout(new BorderLayout());
        pl2.add(pl3, BorderLayout.NORTH);
        pl2.add(pl4, BorderLayout.CENTER);
        pl3.add(la);
        pl4.setLayout(new BorderLayout());
        pl4.setBackground(Color.red);
        la.setFont(new Font("Aptos", Font.PLAIN, 20));
        pl3.setBackground(Color.BLACK);
        la.setForeground(Color.WHITE);

        String[] columnNames = {"ID", "Name", "Quantity", "Price", "Type"};
        tableModel = new DefaultTableModel(columnNames, 0);
        table = new JTable(tableModel);
        String sql = "SELECT * FROM inventory";

        JScrollPane scrollPane = new JScrollPane(table);
        pl4.add(scrollPane, BorderLayout.CENTER);

        bt.addActionListener(e -> {
            String id = tx.getText();
            String name = tx2.getText();
            String quantity = tx3.getText();
            String price = tx4.getText();
            String type = (String) tx5.getSelectedItem();
            if (!id.isEmpty() && !name.isEmpty() && !quantity.isEmpty() && !price.isEmpty() && !type.isEmpty()) {
                String[] rowData = {id, name, quantity, price, type};
                tableModel.addRow(rowData);
                clearTextFields();
                saveInventoryToFile();
            } else {
                JOptionPane.showMessageDialog(fr, "Please fill out all fields.");
            }
        });

        bt3.addActionListener(e -> {
            int selectedRow = table.getSelectedRow();
            if (selectedRow != -1) {
                String newName = JOptionPane.showInputDialog(fr, "Enter new name:");
                String newQuantity = JOptionPane.showInputDialog(fr, "Enter new quantity:");
                if (newName != null && !newName.isEmpty() && newQuantity != null && !newQuantity.isEmpty()) {
                    tableModel.setValueAt(newName, selectedRow, 1);
                    int oldQuantity = Integer.parseInt((String) tableModel.getValueAt(selectedRow, 2));
                    int newQuantityInt = Integer.parseInt(newQuantity);
                    int diff = newQuantityInt - oldQuantity;
                    tableModel.setValueAt(newQuantity, selectedRow, 2);
                    String id = (String) tableModel.getValueAt(selectedRow, 0);
                    updateInventoryQuantity(id, diff);
                    saveInventoryToFile();
                }
            } else {
                JOptionPane.showMessageDialog(fr, "Please select a row to edit.");
            }
        });

        bt4.addActionListener(e -> {
            int selectedRow = table.getSelectedRow();
            if (selectedRow != -1) {
                tableModel.removeRow(selectedRow);
                saveInventoryToFile();
            } else {
                JOptionPane.showMessageDialog(fr, "Please select a row to remove.");
            }
        });

        bt2.addActionListener(e -> {
            String searchID = JOptionPane.showInputDialog(fr, "Enter ID to search:");
            if (searchID != null && !searchID.isEmpty()) {
                boolean found = false;
                for (int i = 0; i < tableModel.getRowCount(); i++) {
                    if (tableModel.getValueAt(i, 0).equals(searchID)) {
                        table.setRowSelectionInterval(i, i);
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    JOptionPane.showMessageDialog(fr, "ID not found.");
                }
            } else {
                JOptionPane.showMessageDialog(fr, "Please enter an ID to search.");
            }
        });

        fr.add(pl, BorderLayout.NORTH);

        pl.add(pl5, BorderLayout.CENTER);
        pl5.add(la2);
        pl5.add(tx);
        pl5.add(la3);
        pl5.add(tx2);
        pl5.add(la4);
        pl5.add(tx3);
        pl5.add(la5);
        pl5.add(tx4);
        pl5.add(la6);
        pl5.add(tx5);
        pl5.add(bt2);
        pl5.add(bt3);
        pl5.add(bt4);

        pl7.add(bt);
        pl5.add(pl7, BorderLayout.SOUTH);

        bt.setBackground(Color.decode("#00CDFF"));
        bt.setForeground(Color.WHITE);
        bt.setPreferredSize(new Dimension(80, 20));

        bt2.setBackground(Color.decode("#00CDFF"));
        bt2.setForeground(Color.WHITE);
        bt2.setPreferredSize(new Dimension(100, 20));

        bt3.setBackground(Color.decode("#00CDFF"));
        bt3.setForeground(Color.WHITE);
        bt3.setPreferredSize(new Dimension(120, 20));

        bt4.setBackground(Color.decode("#00CDFF"));
        bt4.setForeground(Color.WHITE);
        bt4.setPreferredSize(new Dimension(100, 20));

        loadInventoryFromFile(sql);
    }

    private void clearTextFields() {
        tx.setText("");
        tx2.setText("");
        tx3.setText("");
        tx4.setText("");
    }

    private void saveInventoryToFile() {
        try {
            ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("inventory.dat"));
            for (int i = 0; i < tableModel.getRowCount(); i++) {
                String id = (String) tableModel.getValueAt(i, 0);
                String name = (String) tableModel.getValueAt(i, 1);
                int quantity = Integer.parseInt((String) tableModel.getValueAt(i, 2)); // Convert quantity to int
                String price = (String) tableModel.getValueAt(i, 3);
                String type = (String) tableModel.getValueAt(i, 4);
                InventoryItem item = new InventoryItem(id, name, quantity, price, type);
                outputStream.writeObject(item);
            }
            outputStream.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(fr, "Error saving inventory data.");
        }
    }
    private void loadInventoryFromFile(String sql) {
        try {
            db = new dbConnect();
            ResultSet rs = db.getConnect(sql);

            int i = 0;
            while (rs.next()){
                i++;
                String id = rs.getString("productID");
                String name = rs.getString("productName");
                int quantity = rs.getInt("productQuantity");
                String price = rs.getString("productPrice");
                String type = rs.getString("productType");
                String[] rowData = {id, name, String.valueOf(quantity), price, type};
                tableModel.addRow(rowData);

                db.disconnect();
            }
        } catch(Exception e) {
            JOptionPane.showMessageDialog(fr, "Error loading inventory data.");
            e.printStackTrace();
        }
    }
//    private void loadInventoryFromFile() {
//        try {
//            ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("inventory.dat"));
//            while (true) {
//                try {
//                    InventoryItem item = (InventoryItem) inputStream.readObject();
//                    String[] rowData = {item.getId(), item.getName(), String.valueOf(item.getQuantity()), item.getPrice(), item.getType()};
//                    tableModel.addRow(rowData);
//                } catch (EOFException e) {
//                    break;
//                }
//            }
//            inputStream.close();
//        } catch (IOException | ClassNotFoundException e) {
//            JOptionPane.showMessageDialog(fr, "Error loading inventory data.");
//        }
//    }

    private void updateInventoryQuantity(String id, int difference) {
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(InventoryGUI2_DB::new);
    }
}
