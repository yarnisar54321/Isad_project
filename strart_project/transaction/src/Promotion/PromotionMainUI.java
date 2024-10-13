package Promotion;

import javax.swing.*;
import java.awt.*;
import decorClass.CircleButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import decorClass.RoundedPanel;
import Promotion.CreatePromotion;

public class PromotionMainUI {
    private JFrame promoFrame;
    private JPanel promoPlate, textPlate, buttonPlate;
    private JScrollPane promoScroller;
    private JLabel promoText;
    private CircleButton addButton, deleteButton;
    private GridBagConstraints gbc;
    private int currentRow = 0, currentCol = 0;
    
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
        
        addButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                new CreatePromotion();
                
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
        
        promoFrame.setResizable(false);
        promoFrame.setVisible(true);
        promoFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public void onPromotionCreated(String promoName, String promoDetail){
        RoundedPanel newProPlate = new RoundedPanel();
                newProPlate.setPreferredSize(new Dimension(100, 200));
                newProPlate.setBackground(new Color((int)(Math.random()* 0x1000000)));

                gbc.gridx = currentCol;
                gbc.gridy = currentRow;
                gbc.insets = new Insets(5, 15, 5, 0);
                gbc.fill = GridBagConstraints.BOTH;
                
                promoPlate.add(newProPlate, gbc);
                currentCol++;
                
                if (currentCol >= 6) {
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
