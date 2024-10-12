package Promotion;

import javax.swing.*;
import java.awt.*;
import decorClass.CircleButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PromotionMainUI {
    private JFrame promoFrame;
    private JPanel promoPlate, textPlate, buttonPlate;
    private JScrollPane promoScroller;
    private JLabel promoText;
    private CircleButton addButton, deleteButton;
    
    private PromotionMainUI(){
        promoFrame = new JFrame("Promotion Manager");
        promoPlate = new JPanel(new GridLayout(1, 5, 5, 0));
        textPlate = new JPanel();
        promoScroller = new JScrollPane();
        promoText = new JLabel("Promotion");
        buttonPlate = new JPanel();
        addButton = new CircleButton();
        deleteButton = new CircleButton("-", 1000, 1000);
        
        addButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                /*&*/
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
        promoFrame.add(promoPlate, BorderLayout.CENTER);
        promoFrame.add(buttonPlate, BorderLayout.SOUTH);
        buttonPlate.setLayout(new FlowLayout(FlowLayout.RIGHT, 20, 7));
        
        buttonPlate.add(deleteButton);
        buttonPlate.add(addButton);
        
        promoFrame.setSize(750, 400);
        textPlate.setPreferredSize(new Dimension(200, 60));
        buttonPlate.setPreferredSize(new Dimension(200, 60));
        buttonPlate.setBackground(new Color(50, 50, 100));
        textPlate.setBackground(new Color(200, 220, 230));
        
        promoFrame.setResizable(false);
        promoFrame.setVisible(true);
        promoFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public static void main(String[] args) {
        new PromotionMainUI();
    }
}
