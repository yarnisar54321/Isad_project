package Main;

import java.awt.*;
import javax.swing.*;
import decorClass.*;

public class MainGUI {
    private JFrame mainFrame;
    private JPanel mainPlate;
    private Icon imgProfile, imgCeckOut, imgAccount, imgPromotion, imgStock, imgList, imgFlag;
    private RoundedPanel nameBG, soldPlate, leftPlate, rightPlate, blank1, blank2, blank3, blank4, blank5, blank6, blank7;
    private RoundedPanel leftUpper, leftUnder, rightUpper, rightUnder;
    private RoundedPanel profilePalte, checkOutPlate, accountPlate, promotionPlate, stockPlate, listPlate, flagPlate;
    private JLabel nameLabel;
    private JScrollPane scrollSold;
    private JTextArea soldArea;
    private RoundedButton logOutBttn, checkOutBttn, accountBttn, promotionBttn, stockBttn, listBttn;
    
    public MainGUI(){
        //main frame attribute
        mainFrame = new JFrame("Main");
        mainPlate = new JPanel(new GridBagLayout());
        //plate for left and right element
        leftPlate = new RoundedPanel(new BorderLayout(10, 10));
        rightPlate = new RoundedPanel(new GridBagLayout());
        //component for left panel
        leftUpper = new RoundedPanel(new GridBagLayout());
        leftUnder = new RoundedPanel(new GridBagLayout());
        blank1 = new RoundedPanel();
        blank2 = new RoundedPanel();
        blank3 = new RoundedPanel();
        blank4 = new RoundedPanel();
        blank5 = new RoundedPanel();
        blank6 = new RoundedPanel();
        blank7 = new RoundedPanel();
        profilePalte = new RoundedPanel(1000, 1000);
        nameBG = new RoundedPanel(new FlowLayout(FlowLayout.LEFT,15, 5));
        nameLabel = new JLabel("Name: ");
        soldPlate = new RoundedPanel();
        scrollSold = new JScrollPane();
        soldArea = new JTextArea();
        logOutBttn = new RoundedButton();
        //component for right panel
        rightUpper = new RoundedPanel(new GridBagLayout());
        rightUnder = new RoundedPanel(new FlowLayout(FlowLayout.RIGHT));
        checkOutPlate = new RoundedPanel();
        accountPlate = new RoundedPanel();
        promotionPlate = new RoundedPanel();
        stockPlate = new RoundedPanel();
        listPlate = new RoundedPanel();
        flagPlate = new RoundedPanel();
        
        //place component in frame
        GridBagConstraints gbMain = new GridBagConstraints();
        gbMain.gridx = 0;
        gbMain.gridy = 0;
        gbMain.weightx = 0.25;
        gbMain.weighty = 1;
        gbMain.gridheight = 1;
        gbMain.gridwidth = 1;
        gbMain.fill = GridBagConstraints.BOTH;
        gbMain.insets = new Insets(5, 5, 5, 5);
        mainPlate.add(leftPlate, gbMain);
        
        gbMain.gridx = 1;
        gbMain.gridy = 0;
        gbMain.weightx = 0.75;
        gbMain.weighty = 1;
        gbMain.gridheight = 1;
        gbMain.gridwidth = 1;
        gbMain.fill = GridBagConstraints.BOTH;
        gbMain.insets = new Insets(5, 5, 5, 5);
        mainPlate.add(rightPlate, gbMain);
        
        //set left panel
        leftPlate.add(leftUpper, BorderLayout.NORTH);
        leftPlate.add(leftUnder, BorderLayout.SOUTH);
        
        //set top left
        GridBagConstraints gbLeftT = new GridBagConstraints();
        gbLeftT.gridx = 0;
        gbLeftT.gridy = 0;
        gbLeftT.gridheight = 1;
        gbLeftT.gridwidth = 1;
        gbLeftT.weightx = 0.5;
        gbLeftT.weighty = 0.5;
        gbLeftT.fill = GridBagConstraints.BOTH;
        gbLeftT.insets = new Insets(5, 5, 5, 5);
        leftUpper.add(profilePalte, gbLeftT);
        
        gbLeftT.gridx = 1;
        gbLeftT.gridy = 0;
        gbLeftT.gridheight = 1;
        gbLeftT.gridwidth = 1;
        gbLeftT.weightx = 0.5;
        gbLeftT.weighty = 0.7;
        gbLeftT.fill = GridBagConstraints.BOTH;
        gbLeftT.insets = new Insets(5, 5, 5, 5);
        leftUpper.add(blank1, gbLeftT);
        
        nameBG.add(nameLabel);
        
        gbLeftT.gridx = 0;
        gbLeftT.gridy = 1;
        gbLeftT.gridheight = 1;
        gbLeftT.gridwidth = 2;
        gbLeftT.weightx = 0.5;
        gbLeftT.weighty = 0.3;
        gbLeftT.fill = GridBagConstraints.BOTH;
        gbLeftT.insets = new Insets(5, 7, 7, 7);
        leftUpper.add(nameBG, gbLeftT);
                
        //set bottom left
        GridBagConstraints gbLeftB = new GridBagConstraints();
        
        soldPlate.add(scrollSold);
        scrollSold.setViewportView(soldArea);
        
        gbLeftB.gridx = 0;
        gbLeftB.gridy = 0;
        gbLeftB.gridheight = 1;
        gbLeftB.gridwidth = 1;
        gbLeftB.weightx = 1;
        gbLeftB.weighty = 0.9;
        gbLeftB.fill = GridBagConstraints.BOTH;
        gbLeftB.insets = new Insets(10, 10, 1, 10);
        leftUnder.add(soldPlate, gbLeftB);
        
        gbLeftB.gridx = 0;
        gbLeftB.gridy = 1;
        gbLeftB.gridheight = 1;
        gbLeftB.gridwidth = 1;
        gbLeftB.weightx = 1;
        gbLeftB.weighty = 0.1;
        gbLeftB.fill = GridBagConstraints.HORIZONTAL;
        gbLeftB.insets = new Insets(5, 25, 1, 25);
        leftUnder.add(logOutBttn, gbLeftB);
        
        //set right panel
        GridBagConstraints gbRight = new GridBagConstraints();
        
        gbRight.gridx = 0;
        gbRight.gridy = 0;
        gbRight.gridheight = 1;
        gbRight.gridwidth = 1;
        gbRight.weightx = 1;
        gbRight.weighty = 0.9;
        gbRight.fill = GridBagConstraints.BOTH;
        gbRight.insets = new Insets(5, 5, 1, 5);
        rightPlate.add(rightUpper, gbRight);
        
        gbRight.gridx = 0;
        gbRight.gridy = 1;
        gbRight.gridheight = 1;
        gbRight.gridwidth = 1;
        gbRight.weightx = 1;
        gbRight.weighty = 0.1;
        gbRight.fill = GridBagConstraints.BOTH;
        gbRight.insets = new Insets(5, 5, 5, 5);
        rightPlate.add(rightUnder, gbRight);
        
        //set top right
        GridBagConstraints gbRightT = new GridBagConstraints();
        
        gbRightT.gridx = 0;
        gbRightT.gridy = 0;
        gbRightT.gridheight = 1;
        gbRightT.gridwidth = 1;
        gbRightT.weightx = 1;
        gbRightT.weighty = 1;
        gbRightT.fill = GridBagConstraints.BOTH;
        gbRightT.insets = new Insets(10, 5, 10, 5);
        rightUpper.add(blank2, gbRightT);
        
        gbRightT.gridx = 1;
        gbRightT.gridy = 0;
        gbRightT.gridheight = 1;
        gbRightT.gridwidth = 1;
        gbRightT.weightx = 1;
        gbRightT.weighty = 1;
        gbRightT.fill = GridBagConstraints.BOTH;
        gbRightT.insets = new Insets(10, 5, 5, 5);
        rightUpper.add(blank3, gbRightT);
        
        gbRightT.gridx = 2;
        gbRightT.gridy = 0;
        gbRightT.gridheight = 1;
        gbRightT.gridwidth = 1;
        gbRightT.weightx = 1;
        gbRightT.weighty = 1;
        gbRightT.fill = GridBagConstraints.BOTH;
        gbRightT.insets = new Insets(10, 5, 5, 5);
        rightUpper.add(blank4, gbRightT);
        
        gbRightT.gridx = 0;
        gbRightT.gridy = 1;
        gbRightT.gridheight = 1;
        gbRightT.gridwidth = 1;
        gbRightT.weightx = 1;
        gbRightT.weighty = 1;
        gbRightT.fill = GridBagConstraints.BOTH;
        gbRightT.insets = new Insets(0, 5, 5, 5);
        rightUpper.add(blank5, gbRightT);
        
        gbRightT.gridx = 1;
        gbRightT.gridy = 1;
        gbRightT.gridheight = 1;
        gbRightT.gridwidth = 1;
        gbRightT.weightx = 1;
        gbRightT.weighty = 1;
        gbRightT.fill = GridBagConstraints.BOTH;
        gbRightT.insets = new Insets(0, 5, 5, 5);
        rightUpper.add(blank6, gbRightT);
        
        gbRightT.gridx = 2;
        gbRightT.gridy = 1;
        gbRightT.gridheight = 1;
        gbRightT.gridwidth = 1;
        gbRightT.weightx = 1;
        gbRightT.weighty = 1;
        gbRightT.fill = GridBagConstraints.BOTH;
        gbRightT.insets = new Insets(0, 5, 5, 5);
        rightUpper.add(blank7, gbRightT);
        
        //set bottom right
        rightUnder.add(flagPlate);

        
        //set color or other attribute in frame
        nameBG.setPreferredSize(new Dimension(50, 7));
        profilePalte.setPreferredSize(new Dimension(50, 50));
        profilePalte.setBackground(new Color(180, 130, 120));
        blank1.setBackground(new Color(140, 150, 200));
        blank2.setBackground(new Color(140, 150, 200));
        blank3.setBackground(new Color(140, 150, 200));
        blank4.setBackground(new Color(140, 150, 200));
        blank5.setBackground(new Color(140, 150, 200));
        blank6.setBackground(new Color(140, 150, 200));
        blank7.setBackground(new Color(140, 150, 200));

        flagPlate.setBackground(new Color(140, 150, 200));
        flagPlate.setPreferredSize(new Dimension(120, 120));
        
        nameLabel.setFont(new Font("Comic Sans MS", 1, 14));
        nameBG.setBackground(new Color(180, 130, 120));
//        nameLabel.setForeground(new Color(230, 230, 230));
        
        scrollSold.setPreferredSize(new Dimension(200, 130));
        soldArea.setFont(new Font("Comic Sans MS", 1, 12));
        scrollSold.setOpaque(false);
        scrollSold.getViewport().setOpaque(false);
        scrollSold.setBorder(null);
        soldArea.setOpaque(false);
        soldArea.setBorder(null);
        scrollSold.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        scrollSold.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        
        logOutBttn.setPreferredSize(new Dimension(10, 30));
        logOutBttn.setText("Log out");
        logOutBttn.setFont(new Font("Comic Sans MS", 1, 14));
        
        leftUpper.setBackground(new Color(200, 150, 140));
        leftUpper.setPreferredSize(new Dimension(50, 170));
        leftUnder.setBackground(new Color(200, 150, 140));
        leftUnder.setPreferredSize(new Dimension(50, 200));
        leftPlate.setBackground(new Color(220, 170, 160));
        rightPlate.setBackground(new Color(220, 170, 160));
        
        rightUpper.setBackground(new Color(200, 150, 140));
        rightUnder.setBackground(new Color(200, 150, 140));
        
        //set frame
        mainFrame.add(mainPlate);
        mainFrame.setSize(800, 500);
        mainFrame.setVisible(true);
        mainFrame.revalidate();
        mainFrame.repaint();
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public String setName(String accName){
        String text = "Name: " + accName;
        return text;
    }
    
    public static void main(String[] args) {
        new MainGUI();
    }
}
