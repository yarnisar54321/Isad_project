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


public class CreatePromotion{
    private JFrame createPromo;
    private JPanel textPlate, detailPlate, buttonPlate, buttonBlog;
    private JButton cancleB, doneB;
    private JLabel header;
    private JTextField namePromo;
    private JTextArea describePromo;
    private PromotionListener promotionListener;
    
    private RoundedPanel detailsPlate;
    private RoundedPanel imagePlate, blank1, blank2;
    private JTextField nameField, sDateField, eDateField, typeField, idField;
    private JTextArea description;
    private JComboBox disRate;
    private JLabel toText;
    private String[] disOpt;

    
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
        namePromo = new JTextField("name");
        describePromo = new JTextArea("Description", 10, 40);
        
        detailsPlate = new RoundedPanel(20, 20, new GridBagLayout());
        imagePlate = new RoundedPanel(20, 20, new GridBagLayout());
        blank1 = new RoundedPanel(20, 20);
        blank2 = new RoundedPanel(20, 20);
        nameField = new JTextField("name", 10);
        sDateField = new JTextField("start date (xxxx-xx-xx)");
        eDateField = new JTextField("end date (xxxx-xx-xx)");
        description = new JTextArea("description", 3, 1);
        typeField = new JTextField("type", 10);
        idField = new JTextField("ID", 10);
        toText = new JLabel("to");
        disOpt = new String[]{"5", "10", "15", "20", "25","30", "35", "40", "45", "50","55", "60", "65", "70", "75", "80"};
        disRate = new JComboBox<>(disOpt);
        
        cancleB.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                createPromo.dispose();
            }
            
        });
        doneB.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                String promoName = namePromo.getText();
                String promoDetails = describePromo.getText();
                double discountRate  = Double.parseDouble((String) disRate.getSelectedItem());
                String promotionType = typeField.getText();
                Date startDate = DateUtils.parseDate(sDateField.getText());
                Date endDate = DateUtils.parseDate(eDateField.getText());
                int promotionID = Integer.parseInt(idField.getText());
                
                Promotion newPromotion = new Promotion(promotionID, promotionType, promoName, discountRate, startDate, endDate);
                
                if (promotionListener != null) {
                    promotionListener.onPromotionCreated(newPromotion);
                }
                
                createPromo.dispose();
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
    
//    public static void main(String[] args) {
//        new CreatePromotion();
//    }
}
