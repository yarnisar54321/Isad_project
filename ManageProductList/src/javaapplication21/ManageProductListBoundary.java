package javaapplication21;

import java.util.*;
import java.io.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javaapplication21.RoundedButton;

public class ManageProductListBoundary extends JFrame {
    public DefaultTableModel model;
    public ArrayList<Object[]> data;
    private JLabel noProductLabel;
    public JTable productTable;
    public JScrollPane scrollPane;

    public ManageProductListBoundary() {
        setTitle("Product List");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // สร้าง JLabel สำหรับหัวเรื่อง
        JLabel titleLabel = new JLabel("Product List", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 24));
        add(titleLabel, BorderLayout.NORTH);

        // ชื่อคอลัมน์ของตาราง
        String[] columnNames = {"Product ID", "Product Name", "Price", "Description"};

        // ข้อมูลสินค้า (สามารถแก้ไขตามต้องการ)
        data = new ArrayList<>();

        // สร้างโมเดลของตาราง
        model = new DefaultTableModel(data.toArray(new Object[0][0]), columnNames);
        productTable = new JTable(model);

        // สร้าง JScrollPane เพื่อให้ตารางสามารถเลื่อนดูข้อมูลได้
        scrollPane = new JScrollPane(productTable);
        
        noProductLabel = new JLabel("No product in product list", JLabel.CENTER);
        noProductLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        noProductLabel.setForeground(Color.RED);
        
//        add(noProductLabel, BorderLayout.CENTER);
        loadDataFromFile();

        // สร้าง JPanel สำหรับปุ่มต่างๆ
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        buttonPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        
        RoundedButton addButton = new RoundedButton("Add");
        RoundedButton editButton = new RoundedButton("Edit");
        RoundedButton removeButton = new RoundedButton("Remove");
        
        addButton.setBackground(new Color(200, 225, 255));
        editButton.setBackground(new Color(200, 225, 255));
        removeButton.setBackground(new Color(200, 225, 255));

        // เพิ่มปุ่มต่างๆ ลงใน buttonPanel
        buttonPanel.add(addButton);
        buttonPanel.add(editButton);
        buttonPanel.add(removeButton);
        
        buttonPanel.add(Box.createHorizontalStrut(185));
        RoundedButton saveButton = new RoundedButton("Save");
        buttonPanel.add(saveButton);
        saveButton.setBackground(new Color(200, 225, 255));
        
        // เพิ่ม buttonPanel ไว้ที่ด้านล่างของหน้าจอ
        add(buttonPanel, BorderLayout.SOUTH);

        // ตั้งค่า ActionListener ให้กับปุ่ม Add
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JTextField productIdField = new JTextField(10);
                JTextField productNameField = new JTextField(10);
                JTextField priceField = new JTextField(10);
                JTextField DescriptionField = new JTextField(20);
                
                JPanel panel = new JPanel();
                panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
                
                panel.add(new JLabel("Product ID:"));
                panel.add(productIdField);
                panel.add(Box.createVerticalStrut(10)); // distance
                panel.add(new JLabel("Product Name:"));
                panel.add(productNameField);
                panel.add(Box.createVerticalStrut(10)); // distance
                panel.add(new JLabel("Price:"));
                panel.add(priceField);
                panel.add(Box.createVerticalStrut(10)); // distacne
                panel.add(new JLabel("Description:"));
                panel.add(DescriptionField);
                int result = JOptionPane.showConfirmDialog(null, panel, "Enter Product Details", JOptionPane.OK_CANCEL_OPTION);
                
                if (result == JOptionPane.OK_OPTION) {
                    String productId = productIdField.getText();
                    String productName = productNameField.getText();
                    String price = priceField.getText();
                    String Description = DescriptionField.getText();
                    Object[] newRow = {productId, productName, price, Description};
                    data.add(newRow);
                    model.addRow(newRow);

                    System.out.print(data.size());
                    System.out.println(data);
                        
                    if (data.size() == 1) {
                            remove(noProductLabel);
                            add(scrollPane, BorderLayout.CENTER);
                            revalidate(); // อัปเดต UI
                            repaint(); // รีเฟรช UI
                        }
                }
                
            }
        });

        // ตั้งค่า ActionListener ให้กับปุ่ม Edit
        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = productTable.getSelectedRow();
                if (selectedRow != -1) {
                    JTextField productIdField = new JTextField(10);
                    JTextField productNameField = new JTextField(10);
                    JTextField priceField = new JTextField(10);
                    JTextField DescriptionField = new JTextField(20);

                    JPanel panel = new JPanel();
                    panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
                    
                    panel.add(new JLabel("Product ID:"));
                    String cellValue = model.getValueAt(selectedRow, 0).toString();
                    productIdField.setText(cellValue);
                    panel.add(productIdField);
                    panel.add(Box.createVerticalStrut(10)); // distance
                    
                    panel.add(new JLabel("Product Name:"));
                    cellValue = model.getValueAt(selectedRow, 1).toString();
                    productNameField.setText(cellValue);
                    panel.add(productNameField);
                    panel.add(Box.createVerticalStrut(10)); // distance
                    
                    panel.add(new JLabel("Price:"));
                    cellValue = model.getValueAt(selectedRow, 2).toString();
                    priceField.setText(cellValue);
                    panel.add(priceField);
                    panel.add(Box.createVerticalStrut(10)); // distacne
                    
                    panel.add(new JLabel("Description:"));
                    cellValue = model.getValueAt(selectedRow, 3).toString();
                    DescriptionField.setText(cellValue);
                    panel.add(DescriptionField);
                    
                    int result = JOptionPane.showConfirmDialog(null, panel, "Enter Product Details", JOptionPane.OK_CANCEL_OPTION);
                    if (result == JOptionPane.OK_OPTION) {
                        String productId = productIdField.getText();
                        String productName = productNameField.getText();
                        String price = priceField.getText();
                        String Description = DescriptionField.getText();
                        model.setValueAt(productId, selectedRow, 0);
                        model.setValueAt(productName, selectedRow, 1);
                        model.setValueAt(price, selectedRow, 2);
                        model.setValueAt(Description, selectedRow, 3);
                        
                        System.out.print(data.size());
                        System.out.println(    data);
                    }
                    
//                    String newName = JOptionPane.showInputDialog("Enter new product name:");
//                    if (newName != null) {
//                        model.setValueAt(newName, selectedRow, 1); // แก้ไขชื่อสินค้า
//                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Please select a row to edit.");
                }
            }
        });

        // ตั้งค่า ActionListener ให้กับปุ่ม Remove
        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = productTable.getSelectedRow();
                if (selectedRow != -1) {
                    // ลบข้อมูลจาก ArrayList
                    data.remove(selectedRow);
                    // ลบข้อมูลจาก model ของ JTable
                    model.removeRow(selectedRow);
                    
                    System.out.print(data.size());
                    System.out.println(    data);
                    
                    // หากไม่มีข้อมูลใน data ให้แสดงข้อความ "No product in product list"
                    if (data.size() == 0) {
                        remove(scrollPane);
                        add(noProductLabel, BorderLayout.CENTER);
                        revalidate(); // อัปเดต UI
                        repaint(); // รีเฟรช UI
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Please select a row to remove.");
                }
            }
        });
        
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // ใช้ JFileChooser เพื่อให้ผู้ใช้เลือกที่เก็บไฟล์
//                JFileChooser fileChooser = new JFileChooser();
//                int result = fileChooser.showSaveDialog(null);
                
                saveDataToFile();
//                if (result == JFileChooser.APPROVE_OPTION) {
//                    File file = fileChooser.getSelectedFile();
//                }
            }
        });
    }
    
    private void saveDataToFile() {
//        String fileName = "data.txt";
//        File file = new File(fileName);
//            try {
//                file.createNewFile(); 
//            } catch (IOException ex) {
//                JOptionPane.showMessageDialog(fr, "Error creating file: " + ex.getMessage());
//                return;
//            }
//        }
//
//            try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
//                writer.write("ID: " + id + "\n");
//                writer.write("Name: " + name + "\n");
//                writer.write("Date Time: " + formattedDateTime + "\n");
//                writer.write("Quantity: " + quantity + "\n");
//                writer.write("-------------------------\n");
//                writer.newLine(); 
//                JOptionPane.showMessageDialog(fr, "Saved to file: " + fileName);
//            } catch (IOException ex) {
//                JOptionPane.showMessageDialog(fr, "Error saving to file: " + ex.getMessage());
//            }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("product_list.txt"))) {
            
            for (Object[] row : data) {
//                StringBuilder sb = new StringBuilder();
//                for (Object value : row) {
//                    
//                    sb.append(value).append("\t"); // ใช้ tab เพื่อคั่นค่าของแต่ละคอลัมน์
//                }
                // ลบเครื่องหมาย tab ตัวสุดท้ายและเขียนบรรทัด
//                writer.write(sb.toString().trim());
//                writer.newLine();
                writer.write("Product ID: " + row[0] + "\n");
                writer.write("Product Name: " + row[1] + "\n");
                writer.write("Product Price: " + row[2] + "\n");
                writer.write("Product Description: " + row[3] + "\n");
                writer.write("-------------------------\n");
                writer.newLine(); 
            }
            JOptionPane.showMessageDialog(this, "Data saved successfully!");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error saving data: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("product_data.dat"))) {
            oos.writeObject(data);
//            JOptionPane.showMessageDialog(this, "Data saved successfully!");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error saving data: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    };

    private void loadDataFromFile() {
    File file = new File("product_data.dat");
    if (file.exists() && file.length() > 0) { // ตรวจสอบว่าไฟล์มีข้อมูล
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            data = (ArrayList<Object[]>) ois.readObject();
            
            // เพิ่มข้อมูลในตาราง
            for (Object[] rowData : data) {
                model.addRow(rowData);
            }
            // แสดงตารางถ้ามีข้อมูล
            if (!data.isEmpty()) {
                add(new JScrollPane(productTable), BorderLayout.CENTER);
            } else {
                add(noProductLabel, BorderLayout.CENTER);
            }
        } catch (IOException | ClassNotFoundException e) {
            JOptionPane.showMessageDialog(this, "Error loading data: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    } else {
        // ถ้าไฟล์ไม่มีข้อมูลหรือไม่พบไฟล์ จะแสดงข้อความ
        add(noProductLabel, BorderLayout.CENTER);
    }
}

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ManageProductListBoundary frame = new ManageProductListBoundary();
            frame.setVisible(true);
        });
    }
}
