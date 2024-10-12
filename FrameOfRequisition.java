/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication31;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.*;

/**
 *
 * @author Yarnisar
 */
public class FrameOfRequisition {
    private JFrame fr;
    private JPanel pn1;
    private JLabel IDLabel,QuantityLabel;
    private JTextField IDField, QuantityField;
    private JButton saveButton;
    private String id;
    private int quantity;
//    private InventoryItem inventoryItem;
    
    public FrameOfRequisition(){
//        inventoryItem = new InventoryItem();
        fr = new JFrame("Datanaja");
        fr.setSize(500, 400);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.setLayout(null);
        
        pn1 = new JPanel();
        pn1.setBounds(50, 50, 400, 200);
        pn1.setLayout(new GridLayout(3, 2, 10, 10));
        
        IDLabel = new JLabel("ID:");
        IDField = new JTextField(10);
        QuantityLabel = new JLabel("Quantity:");
        QuantityField = new JTextField(10);

        pn1.add(IDLabel);
        pn1.add(IDField);
        pn1.add(QuantityLabel);
        pn1.add(QuantityField);
        saveButton = new JButton("Save to File");
        saveButton.setBounds(180, 300, 120, 40); 
        
        saveButton.addActionListener(new ActionListener() {
        DateTimeFormatter dateTimeFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String formattedDateTime = now.format(dateTimeFormat);
        
        
            public void actionPerformed(ActionEvent e) {
                id = IDField.getText();
                String quantitystr = QuantityField.getText();
                quantity = Integer.parseInt(quantitystr);
//                 if(getId != null&& inventoryItem.getId().equals(id)){
//                    String name = inventoryItem.getName();
                 saveDataRequisition(id, quantity, formattedDateTime);
                }
            
        });
        fr.add(pn1);
        fr.add(saveButton);
        fr.setVisible(true);
    }
      
         
        private static void saveDataRequisition(String id, int quantity, String dateTime) {           
            try {      
                FileWriter writer = new FileWriter("Requisitiondata.txt", true); 
//                writer.write("Name: " + name+ "\n");
                writer.write("ID: " + id+ "\n");
                writer.write("Quantity: " + quantity + "\n");
                writer.write("Date&Time: " + dateTime + "\n");//auto
                writer.write("--------------------------\n");
                writer.close(); 
                JOptionPane.showMessageDialog(null, "Data saved successfully!");
                
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Error saving data.");
                e.printStackTrace();
            }
    }
        
}
