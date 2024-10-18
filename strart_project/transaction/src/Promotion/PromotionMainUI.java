package Promotion;

import javax.swing.*;
import java.awt.*;
import decorClass.CircleButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;

import decorClass.RoundedPanel;
import Promotion.CreatePromotion;
import Promotion.Promotion.PromotionListener;

public class PromotionMainUI implements PromotionListener{
    private JFrame promoFrame;
    private JPanel promoPlate, textPlate, buttonPlate;
    private JScrollPane promoScroller;
    private JLabel promoText;
    private CircleButton addButton, deleteButton;
    private GridBagConstraints gbc;
    private int currentRow = 0, currentCol = 0;
    private LocalDate dateToday;
    
    private PromotionMainUI(){
        promoFrame = new JFrame("Promotion Manager");
        promoPlate = new JPanel(new GridBagLayout());
        textPlate = new JPanel();
        promoScroller = new JScrollPane();
        promoText = new JLabel("Promotion");
        buttonPlate = new JPanel();
        addButton = new CircleButton();
        deleteButton = new CircleButton("-", 1000, 1000);
        gbc = new GridBagConstraints();
        dateToday = LocalDate.now();
        
        addButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                new CreatePromotion(PromotionMainUI.this);
            }
            
        });
        
        deleteButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                /**/
            }
            
        });
        
        promoFrame.setLayout(new BorderLayout());
        promoText.setFont(new Font("Comic Sans MS", 1, 24));
        addButton.setPreferredSize(new Dimension(45, 45));
        deleteButton.setPreferredSize(new Dimension(45, 45));
        
        textPlate.add(promoText);
        promoFrame.add(textPlate, BorderLayout.NORTH);
        promoFrame.add(promoScroller, BorderLayout.CENTER);
        promoFrame.add(buttonPlate, BorderLayout.SOUTH);
        
        promoScroller.setViewportView(promoPlate);
        
        buttonPlate.setLayout(new FlowLayout(FlowLayout.RIGHT, 20, 7));
        
        buttonPlate.add(deleteButton);
        buttonPlate.add(addButton);
        
        promoFrame.setSize(750, 400);
        promoScroller.getViewport().setBackground(new Color(200, 230, 230));
        promoPlate.setBackground(new Color(180, 220, 240));
        textPlate.setPreferredSize(new Dimension(200, 60));
        buttonPlate.setPreferredSize(new Dimension(200, 60));
        buttonPlate.setBackground(new Color(50, 50, 100));
        textPlate.setBackground(new Color(200, 220, 230));

        loadPromotionFiles();

        promoFrame.setResizable(false);
        promoFrame.setVisible(true);
        promoFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
                        if (line.trim().isEmpty()) {
                            continue;
                        }

                        try {
                            String[] promotionIdParts = line.split(": ");
                            if (promotionIdParts.length < 2) {
                                System.err.println("Invalid line format: " + line);
                            }
                            int promotionID = Integer.parseInt(promotionIdParts[1].trim());

                            String promotionName = reader.readLine();
                            String promotionType = reader.readLine();
                            String discountRateLine = reader.readLine();
                            String startDateLine = reader.readLine();
                            String endDateLine = reader.readLine();
                            String promoDetailsLine = reader.readLine();

                            if (promotionName == null || promotionType == null || discountRateLine == null || startDateLine == null || endDateLine == null || promoDetailsLine == null) {
                                System.err.println("Missing details");
                                continue;
                            }

                            String[] promotionNameParts = promotionName.split(": ");
                            String[] promotionTypeParts = promotionType.split(": ");
                            String[] discountRateParts = discountRateLine.split(": ");
                            String[] startDateParts = startDateLine.split(": ");
                            String[] endDateParts = endDateLine.split(": ");
                            String[] promoDetailsParts = promoDetailsLine.split(": ");

                            if (promotionNameParts.length < 2 || promotionTypeParts.length < 2 ||
                                    discountRateParts.length < 2 || startDateParts.length < 2 ||
                                    endDateParts.length < 2 || promoDetailsParts.length < 2) {
                                System.err.println("Invalid line format");
                                continue;
                            }

                            String promotionNameValue = promotionNameParts[1].trim();
                            String promotionTypeValue = promotionTypeParts[1].trim();
                            double discountRate = Double.parseDouble(discountRateParts[1].replace("%", "").trim());
                            LocalDate startDate = LocalDate.parse(startDateParts[1].trim());
                            LocalDate endDate = LocalDate.parse(endDateParts[1].trim());
                            String promoDetails = promoDetailsParts[1].trim();

                            System.out.println(promotionID);
                            System.out.println(promotionTypeValue);
                            System.out.println(promotionNameValue);
                            System.out.println(promoDetails);
                            System.out.println(discountRate);
                            System.out.println(startDate);
                            System.out.println(endDate);
                            Promotion promotion = new Promotion(promotionID, promotionTypeValue, promotionNameValue, promoDetails, discountRate, startDate, endDate);
                            onPromotionCreated(promotion);
                        } catch (IOException | NumberFormatException e) {
                            e.printStackTrace();
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }



            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void onPromotionCreated(Promotion promotion){
        RoundedPanel newProPlate = new RoundedPanel();
        newProPlate.setPreferredSize(new Dimension(250, 200));
        newProPlate.setBackground(new Color(220, 230, 250));
        
        JLabel idLabel = new JLabel("ID: " + promotion.getPromotionID());
        JLabel typeLabel = new JLabel("Type: " + promotion.getPromotionType());
        JLabel nameLabel = new JLabel("Name: " +  promotion.getPromotionName());
        JLabel disRateLabel = new JLabel("Discount: " + promotion.getDiscountRate() + " %");
        JLabel sDateLabel = new JLabel("Start Date: " + promotion.getStartDate());
        JLabel eDateLabel = new JLabel("End Date: " + promotion.getEndDate());
        
        newProPlate.setLayout(new GridBagLayout());
        
        GridBagConstraints proCon = new GridBagConstraints();
        proCon.gridx = 0;
        proCon.gridy = 0;
        proCon.gridheight = 1;
        proCon.gridwidth = 1;
        proCon.weightx = 1;
        proCon.weighty = 0.5;
        proCon.fill = GridBagConstraints.HORIZONTAL;
        proCon.insets = new Insets(10, 10, 10, 10);
        newProPlate.add(idLabel, proCon);
        
        proCon.gridy = 1;
        newProPlate.add(typeLabel, proCon);
        
        proCon.gridy = 2;
        newProPlate.add(nameLabel,proCon);
        
        proCon.gridy = 1;
        proCon.gridx = 1;
        newProPlate.add(disRateLabel,proCon);
        
        proCon.gridy = 4;
        proCon.gridx = 0;
        proCon.gridheight = 1;
        proCon.gridwidth = 2;
        newProPlate.add(sDateLabel,proCon);
        
        proCon.gridy = 5;
        newProPlate.add(eDateLabel,proCon);

        gbc.gridx = currentCol;
        gbc.gridy = currentRow;
        gbc.insets = new Insets(5, 15, 5, 0);
        gbc.fill = GridBagConstraints.BOTH;

        promoPlate.add(newProPlate, gbc);
        currentCol++;

        if (currentCol >= 3) {
            currentCol = 0;
            currentRow++;
        }

        promoPlate.revalidate();
        promoPlate.repaint();
    }
    
    public static void main(String[] args) {
        new PromotionMainUI();
    }
}
