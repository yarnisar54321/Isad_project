package javaapplication31;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javaapplication31.InventoryItem;
import decorClass.RoundedButton;

public class StockManagerBounary{
    private JFrame fr;
    private JPanel headerPanel, pl2, pl3, pl4, inputPanel, buttonPanel, bottomPlate, showPlate;
    private RoundedButton addBn, searchBn, editBn, removeBn, requisitionBn;
    private JLabel headerText, idText, nameText, quantityText, priceText, typeText;
    private JTextField idField, nameField, quantityField, priceField;
    private JComboBox <String> typeBox;
    private DefaultTableModel tableModel;
    private JTextArea showArea;
    private JTable table;
    private InventoryItem item;
    private JScrollPane scrollPane, scrollView;
    private JTextPane textPane;

//    private ArrayList<InventoryItem> inventoryList = new ArrayList<>();

    

    public StockManagerBounary() {
        fr = new JFrame("Stock Manage");
        showPlate = new JPanel();
        scrollView = new JScrollPane();
        showArea = new JTextArea(100,125);
        textPane = new JTextPane();
        textPane.setSize(100, 125);
        
        showPlate.add(scrollView);
        scrollView.setPreferredSize(new Dimension(1300, 300));
        scrollView.setViewportView(showArea);
        showArea.setLineWrap(true); 
        showArea.setWrapStyleWord(true); 
        showArea.setEditable(false); 
        
//        scrollPane = new JScrollPane(showArea); 
//        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS); 
        loadTextFile();
        headerPanel = new JPanel();
        pl2 = new JPanel();
        pl3 = new JPanel();
        pl4 = new JPanel();
        inputPanel = new JPanel();
        buttonPanel = new JPanel();
        bottomPlate = new JPanel();
        

        addBn = new RoundedButton("Add", 15, 15);
        searchBn = new RoundedButton("Search", 15, 15);
        editBn = new RoundedButton("Edit", 15, 15);
        removeBn = new RoundedButton("Remove", 15, 15);        
        requisitionBn = new RoundedButton("requisition", 15, 15);
        
        headerText= new JLabel("Inventory Management ");
        idText = new JLabel("ID");
        nameText = new JLabel("Name");
        quantityText = new JLabel("Quantity");
        priceText = new JLabel("Price");
        typeText = new JLabel("Type");
        idField = new JTextField(10);
        nameField = new JTextField(10);
        quantityField = new JTextField(10);
        priceField = new JTextField(10);
        typeBox = new JComboBox<>(new String[]{"Food", "Beve", "General merchandise", "Personal care products"});

        fr.setLayout(new BorderLayout());
        fr.setVisible(true);
        fr.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        fr.setSize(650, 400);


        headerPanel.setLayout(new BorderLayout());
        headerPanel.add(pl2, BorderLayout.NORTH);

        pl2.setLayout(new BorderLayout());
        pl2.add(pl3, BorderLayout.NORTH);
        pl2.add(pl4, BorderLayout.CENTER);
        pl3.add(headerText);
        pl4.setLayout(new BorderLayout());
        pl4.setBackground(Color.red);
        headerText.setFont(new Font("Aptos", Font.PLAIN, 18));
        bottomPlate.setBackground(Color.BLACK);/////////////////////////////////////
        pl3.setBackground(Color.decode("#9379c2"));
        headerText.setForeground(Color.WHITE);

        
        
        String[] columnNames = {"ID", "Name", "Quantity", "Price", "Type"};
        tableModel = new DefaultTableModel(columnNames, 0);
        table = new JTable(tableModel);

        
        
        JScrollPane scrollPane = new JScrollPane(table);
        pl4.add(scrollPane, BorderLayout.CENTER);
        loadTextFile();
        
        
        addBn.addActionListener(e -> {
            String id = idField.getText();
            String name = nameField.getText();////////////////////////////////////////////
            String quantity = quantityField.getText();
            String price = priceField.getText();
            String type = (String) typeBox.getSelectedItem();
            if (!id.isEmpty() && !name.isEmpty() && !quantity.isEmpty() && !price.isEmpty() && !type.isEmpty()) {
                String[] rowData = {id, name, quantity, price, type};
               
                tableModel.addRow(rowData);
                JOptionPane.showMessageDialog(fr, "add successfully");
                clearTextFields();
                saveInventoryToFile();
                
            } else {
                JOptionPane.showMessageDialog(fr, "Please fill out all fields.");
            }
        });

        editBn.addActionListener(e -> {
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

        removeBn.addActionListener(e -> {
            int selectedRow = table.getSelectedRow();
            if (selectedRow != -1) {
                tableModel.removeRow(selectedRow);
                saveInventoryToFile();
            } else {
                JOptionPane.showMessageDialog(fr, "Please select a row to remove.");
            }
        });

        searchBn.addActionListener(e -> {
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
        
        requisitionBn.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
        String searchID = JOptionPane.showInputDialog(fr, "Enter ID to search:");
        if (searchID != null && !searchID.isEmpty()) {
            boolean found = false;
            for (int i = 0; i < tableModel.getRowCount(); i++) {
                if (tableModel.getValueAt(i, 0).equals(searchID)) {
                    table.setRowSelectionInterval(i, i);
                    found = true;

                    String quantity = JOptionPane.showInputDialog(fr, "Enter quantity:");
                    if (quantity == null || quantity.isEmpty()) {
                        JOptionPane.showMessageDialog(fr, "Please enter a quantity.");
                        return;
                    }

                    String id = (String) tableModel.getValueAt(i, 0);
                    String name = (String) tableModel.getValueAt(i, 1);

                    LocalDate currentDate = LocalDate.now();
                    DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                    String formattedDate = currentDate.format(dateFormatter);


                    String fileName = "Requisition_" + formattedDate + ".txt";//save name date.txt

                    LocalDateTime now = LocalDateTime.now();
                    DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
                    String formattedDateTime = now.format(timeFormatter);

                    File file = new File(fileName);
                    if (!file.exists()) {
                        try {
                            file.createNewFile(); 
                        } catch (IOException ex) {
                            JOptionPane.showMessageDialog(fr, "Error creating file: " + ex.getMessage());
                            return;
                        }
                    }

                    try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
                        writer.write("-------------------------\n");
                        writer.write("Date Time: " + formattedDateTime + "\n");
                        writer.write("Quantity: " + quantity + "\n");
                        writer.write("Name: " + name + "\n");
                        writer.write("ID: " + id + "\n");
                        
                        writer.newLine(); 
                        JOptionPane.showMessageDialog(fr, "Saved to file: " + fileName);
                        String oldText = showArea.getText();
                        String newText =  "ID: " + id + "\n"+"Name: " + name + "\n"+"Quantity: " + quantity + "\n"+"Date Time: " + formattedDateTime + "\n-------------------------\n";
                showArea.setText(newText + oldText);
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(fr, "Error saving to file: " + ex.getMessage());
                    }
                    break;
                }
            }
            if (!found) {
                displayErrorMessage();
            }
        } else {
            JOptionPane.showMessageDialog(fr, "Please enter an ID to search.");
        }
    }
});
        
        
        fr.add(headerPanel, BorderLayout.NORTH);
        fr.add(inputPanel, BorderLayout.CENTER);
        inputPanel.add(idText);
        inputPanel.add(idField);
        inputPanel.add(nameText);
        inputPanel.add(nameField);
        inputPanel.add(quantityText);
        inputPanel.add(quantityField);
        inputPanel.add(priceText);
        inputPanel.add(priceField);
        inputPanel.add(typeText);
        inputPanel.add(typeBox);
        inputPanel.add(searchBn);
        inputPanel.add(editBn);
        inputPanel.add(removeBn);
        inputPanel.add(requisitionBn);
        buttonPanel.add(addBn);
        inputPanel.add(buttonPanel, BorderLayout.SOUTH);
        bottomPlate.add(showPlate);

        fr.add(bottomPlate, BorderLayout.SOUTH);
        
        typeBox.setBackground(new Color(235,240,  255));
        

        addBn.setBackground(Color.decode("#78A3D4"));
        addBn.setForeground(Color.WHITE);
        addBn.setPreferredSize(new Dimension(80, 30));

        searchBn.setBackground(Color.decode("#78A3D4"));
        searchBn.setForeground(Color.WHITE);
        searchBn.setPreferredSize(new Dimension(100, 30));

        editBn.setBackground(Color.decode("#78A3D4"));
        editBn.setForeground(Color.WHITE);
        editBn.setPreferredSize(new Dimension(80, 30));

        removeBn.setBackground(Color.decode("#78A3D4"));
        removeBn.setForeground(Color.WHITE);
        removeBn.setPreferredSize(new Dimension(100, 30));
        
        requisitionBn.setBackground(Color.decode("#78A3D4"));
        requisitionBn.setForeground(Color.WHITE);
        requisitionBn.setPreferredSize(new Dimension(120, 30));
        loadInventoryFromFile();
        
        fr.setExtendedState(JFrame.MAXIMIZED_BOTH);
        fr.setResizable(false);
    }
    
    public void displayLoginPage(){
         //new Jframe login
    }
    public void displayErrorMessage(){
         JOptionPane.showMessageDialog(fr, "ID not found.");
        
        
        
     }
    private void clearTextFields() {
        idField.setText("");
        nameField.setText("");
        quantityField.setText("");
        priceField.setText("");
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
   
   private void oldText(String id, String name, int quantity, String formattedDateTime){
       showArea.append("ID: " + id + "\n"+"Name: " + name + "\n"+"Quantity: " + quantity + "\n"+"Date Time: " + formattedDateTime);

   }

    private void loadInventoryFromFile() {
        try {
            ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("inventory.dat"));
            while (true) {
                try {
                    InventoryItem item = (InventoryItem) inputStream.readObject();
                    String[] rowData = {item.getId(), item.getName(), String.valueOf(item.getQuantity()), item.getPrice(), item.getType()};
                    tableModel.addRow(rowData);
                } catch (EOFException e) {
                    break;
                }
            }
            inputStream.close();
        } catch (IOException | ClassNotFoundException e) {
            JOptionPane.showMessageDialog(fr, "Error loading inventory data.");
        }
    }
    
    private void loadTextFile() {
    String fileName = "Requisition_" + LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")) + ".txt";
    File file = new File(fileName);
    if (file.exists()) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            ArrayList<String> lines = new ArrayList<>();
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
            StringBuilder content = new StringBuilder();
            for (int i = lines.size() - 1; i >= 0; i--) {//loop back .txt 
                content.append(lines.get(i)).append("\n");
            }

            showArea.setText(content.toString());
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(fr, "Error loading file: " + ex.getMessage());
        }
    } else {
        showArea.setText("No previous requisition data found.");
    }
}



    private void updateInventoryQuantity(String id, int difference) {
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(StockManagerBounary::new);
//            new StockManagerBounary();
    }
}
