package Promotion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Promotion.PromoPlate;
import Promotion.Promotion.PromotionListener;
import decorClass.RoundedPanel;
import java.util.Date;
import Promotion.DateUtils;
import java.awt.event.*;
import java.io.*;
import java.time.LocalDate;

public class CreatePromotion{
    private JFrame createPromo;
    private JPanel textPlate, detailPlate, buttonPlate, buttonBlog;
    private JButton cancleB, doneB;
    private JLabel header;
    private PromotionListener promotionListener;
    
    private RoundedPanel detailsPlate;
    private RoundedPanel imagePlate, blank1, blank2;
    private JTextField nameField, sDateField, eDateField, typeField, idField;
    private JTextArea description;
    private JComboBox disRate;
    private JLabel toText;
    private Double[] disOpt;
    private LocalDate dateToday;

    
    private String promoName;
    private String promoDetails;
    
    CreatePromotion(PromotionListener listener){
        this.promotionListener = listener;
        
        createPromo = new JFrame("Create new Promotion");
        textPlate = new JPanel(new FlowLayout(FlowLayout.CENTER));
        detailPlate = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPlate = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttonBlog = new JPanel();
        cancleB = new JButton("Cancle");
        doneB = new JButton("Done");
        header = new JLabel("Create Promotion");
        dateToday = LocalDate.now();
        
        detailsPlate = new RoundedPanel(20, 20, new GridBagLayout());
        imagePlate = new RoundedPanel(20, 20, new GridBagLayout());
        blank1 = new RoundedPanel(20, 20);
        blank2 = new RoundedPanel(20, 20);
        nameField = new JTextField("name", 10);
        sDateField = new JTextField(DateUtils.formatDate(dateToday));
        eDateField = new JTextField("end date (yyyy-mm-dd)");
        description = new JTextArea("description", 3, 1);
        typeField = new JTextField("type", 10);
        idField = new JTextField("ID", 10);
        toText = new JLabel("to");
        disOpt = new Double[]{5.0, 10.0, 15.0, 20.0, 25.0, 30.0, 35.0, 40.0, 45.0, 50.0, 55.0, 60.0, 65.0, 70.0, 75.0, 80.0};
        disRate = new JComboBox<>(disOpt);

        cancleB.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                createPromo.dispose();
            }
        });
        
        doneB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                savePromotionToFile();
            }
        });
        
        idField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                idField.selectAll();
            }
        });
        nameField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                nameField.selectAll();
            }
        });
        sDateField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                sDateField.selectAll();
            }
        });
        eDateField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                eDateField.selectAll();
            }
        });
        typeField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                typeField.selectAll();
            }
        });
        description.addFocusListener(new FocusAdapter(){
            @Override
            public void focusGained(FocusEvent e) {
                description.selectAll();
            }
        });
        
        GridBagConstraints gb = new GridBagConstraints();
        gb.gridx = 1;
        gb.gridy = 0;
        gb.weightx = 0.4;
        gb.weighty = 0.4;
        gb.gridheight = 1;
        gb.gridwidth = 1;
        gb.fill = GridBagConstraints.BOTH;
        gb.insets = new Insets(5, 5, 5, 5);
        detailsPlate.add(imagePlate, gb);
        
        gb.gridx = 0;
        gb.gridy = 0;
        gb.weightx = 0.4;
        gb.fill = GridBagConstraints.HORIZONTAL;
        gb.insets = new Insets(5, 10, 5, 15);
        detailsPlate.add(idField, gb);
        
        gb.gridx = 0;
        gb.gridy = 1;
        gb.weightx = 1;
        gb.weighty = 0.4;
        gb.gridwidth = 2;
        gb.gridheight = 1;
        gb.fill = GridBagConstraints.BOTH;
        gb.insets = new Insets(10, 5, 10, 5);
        detailsPlate.add(description, gb);
        
        gb.gridx = 0;
        gb.gridy = 2;
        gb.weighty = 0.2;
        detailsPlate.add(disRate, gb);
        
        GridBagConstraints gb_head = new GridBagConstraints();
        gb_head.gridx = 0;
        gb_head.gridy = 0;
        gb_head.weightx = 1;
        gb_head.weighty = 1;
        gb_head.gridheight = 1;
        gb_head.gridwidth = 1;
        gb_head.fill = GridBagConstraints.HORIZONTAL;
        gb_head.insets = new Insets(5, 5, 5, 5);
        imagePlate.add(nameField, gb_head);
        
        gb_head.gridx = 0;
        gb_head.gridy = 1;
        imagePlate.add(typeField, gb_head);
        
        gb_head.gridx = 0;
        gb_head.gridy = 2;
        imagePlate.add(sDateField, gb_head);
        
        gb_head.gridx = 0;
        gb_head.gridy = 3;
        gb_head.fill = GridBagConstraints.VERTICAL;
        gb_head.insets = new Insets(0, 0, 0, 0);
        imagePlate.add(blank1, gb_head);
        blank1.add(toText);
        
        gb_head.gridx = 0;
        gb_head.gridy = 4;
        gb_head.fill = GridBagConstraints.HORIZONTAL;
        gb_head.insets = new Insets(5, 5, 5, 5);
        imagePlate.add(eDateField, gb_head);
        
        detailsPlate.setBackground(new Color(200, 150, 150));
        imagePlate.setBackground(new Color(230, 200, 200));
        blank1.setBackground(new Color(255, 230, 230));

        detailPlate.add(detailsPlate);
        createPromo.setLayout(new BorderLayout());
        buttonBlog.setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 0));
        createPromo.add(textPlate, BorderLayout.NORTH);
        createPromo.add(detailPlate, BorderLayout.CENTER);
        createPromo.add(buttonPlate, BorderLayout.SOUTH);
        buttonBlog.add(cancleB);
        buttonBlog.add(doneB);
        buttonPlate.add(buttonBlog);
        textPlate.add(header);
        
        header.setFont(new Font("Comic Sans MS", 1, 24));
        
        createPromo.setResizable(false);
        createPromo.setSize(750, 400);
        createPromo.setVisible(true);
        createPromo.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    
    private boolean isIDExistInFile(String fileName, int promotionID) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains("Promotion ID: " + promotionID)) {
                    return true; 
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false; 
    }
    private void savePromotionToFile() {
        try {
            String promoName = nameField.getText();
            String promoDetails = description.getText();
            double discountRate = (double) disRate.getSelectedItem();
            String promotionType = typeField.getText();
            LocalDate startDate = LocalDate.parse(sDateField.getText());
            LocalDate endDate = LocalDate.parse(eDateField.getText());
            int promotionID = Integer.parseInt(idField.getText());

            Promotion newPromotion = new Promotion(promotionID, promotionType, promoName, promoDetails, discountRate, startDate, endDate);

            File promoFile = new File("Promotion.txt");

            try (FileWriter writer = new FileWriter(promoFile, true)) {
                // Write the promotion details
                writer.write("Promotion ID: " + promotionID + "\n");
                writer.write("Name: " + promoName + "\n");
                writer.write("Type: " + promotionType + "\n");
                writer.write("Discount Rate: " + discountRate + "%\n");
                writer.write("Start Date: " + startDate + "\n");
                writer.write("End Date: " + endDate + "\n");
                writer.write("Description: " + promoDetails + "\n");
                writer.write("\n"); // Add a newline after each promotion for better readability
            }

            if (promotionListener != null) {
                promotionListener.onPromotionCreated(newPromotion);
            }

            createPromo.dispose();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }



    private void loadPromotionFiles() {
        //no folder no data ja
        File promotionDir = new File("promotionData");
        if (!promotionDir.exists() || !promotionDir.isDirectory()) {
            System.out.println("no folder found");
            return;
        }

        File[] files = promotionDir.listFiles((dir, name) -> name.startsWith("Promo_EndDate_") && name.endsWith(".txt"));
        if (files == null) return;

        for (File file : files) {
            try {
                //get date from file name, 4 = ".txt"
                String fileName = file.getName();
                String dateString = fileName.substring("Promo_EndDate_".length(), fileName.length() - 4);
                LocalDate fileEndDate = LocalDate.parse(dateString);

                if (fileEndDate.isBefore(dateToday)) {
                    file.delete();
                    System.out.println("file deleted");
                    continue;
                }

                try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                    String line;
                    while ((line = reader.readLine()) != null) {
                        line = line.trim();
                        if (line.isEmpty()) {
                            continue;
                        }
                        if (line.startsWith("[NEXT PROMO]")) {
                            continue;
                        }

                        int promotionID = Integer.parseInt(reader.readLine().split(": ")[1].trim());
                        String promotionName = reader.readLine().split(": ")[1].trim();
                        String promotionType = reader.readLine().split(": ")[1].trim();
                        double discountRate = Double.parseDouble(reader.readLine().split(": ")[1].replace("%", "").trim());
                        LocalDate startDate = LocalDate.parse(reader.readLine().split(": ")[1].trim());
                        LocalDate endDate = LocalDate.parse(reader.readLine().split(": ")[1].trim());
                        String promoDetails = reader.readLine().split(": ")[1].trim();

                        Promotion promotion = new Promotion(promotionID, promotionType, promotionName, promoDetails, discountRate, startDate, endDate);
                        if (promotionListener != null) {
                            promotionListener.onPromotionCreated(promotion);
                        }

                        reader.readLine();
                    }
                }

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

}