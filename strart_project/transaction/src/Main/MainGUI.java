package Main;

import java.awt.*;
import javax.swing.*;
import decorClass.*;

public class MainGUI {
    private JFrame mainFrame;
    private JPanel mainPlate;
    private ImageIcon imgProfile, imgCheckOut, imgAccount, imgPromotion, imgStock, imgList, imgFlag;
    private RoundedPanel nameBG, soldPlate, leftPlate, rightPlate, blank1, blank2, blank3, blank4, blank5, blank6, blank7, blank8;
    private RoundedPanel leftUpper, leftUnder, rightUpper, rightUnder;
    private RoundedPanel profilePalte, checkOutPlate, accountPlate, promotionPlate, stockPlate, listPlate, flagPlate;
    private JLabel profileLabel, checkOutLabel, accountLabel, promotionLabel, stockLabel, listLabel, flagLabel;
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
        blank8 = new RoundedPanel();
        profilePalte = new RoundedPanel(1000, 1000);
        nameBG = new RoundedPanel(new FlowLayout(FlowLayout.LEFT,15, 5));
        nameLabel = new JLabel("Name: ");
        soldPlate = new RoundedPanel();
        scrollSold = new JScrollPane();
        soldArea = new JTextArea();
        logOutBttn = new RoundedButton();
        
        //component for right panel
        rightUpper = new RoundedPanel(new GridBagLayout());
        rightUnder = new RoundedPanel(new GridBagLayout());
        checkOutPlate = new RoundedPanel(new GridBagLayout());
        accountPlate = new RoundedPanel(new GridBagLayout());
        promotionPlate = new RoundedPanel(new GridBagLayout());
        stockPlate = new RoundedPanel(new GridBagLayout());
        listPlate = new RoundedPanel(new GridBagLayout());
        flagPlate = new RoundedPanel(new GridBagLayout());
        checkOutLabel = new JLabel();
        accountLabel = new JLabel();
        promotionLabel = new JLabel();
        stockLabel = new JLabel();
        listLabel = new JLabel();
        flagLabel = new JLabel();
        checkOutBttn = new RoundedButton("Checkout", 20, 20);
        accountBttn = new RoundedButton("Account", 20, 20);
        promotionBttn = new RoundedButton("promotion", 20, 20);
        stockBttn = new RoundedButton("Stock", 20, 20);
        listBttn = new RoundedButton("Product List", 20, 20);
        
        //import image
        imgProfile = new ImageIcon(getClass().getResource("/Main/mainIcon/flag.png"));
        imgCheckOut = new ImageIcon(getClass().getResource("/Main/mainIcon/checkout.png"));
        imgAccount = new ImageIcon(getClass().getResource("/Main/mainIcon/salesanalytics.png"));
        imgPromotion = new ImageIcon(getClass().getResource("/Main/mainIcon/profile.png"));
        imgStock = new ImageIcon(getClass().getResource("/Main/mainIcon/stock.png"));
        imgList = new ImageIcon(getClass().getResource("/Main/mainIcon/productlist.png"));
        imgFlag = new ImageIcon(getClass().getResource("/Main/mainIcon/flag.png"));
        
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
        gbRight.weighty = 0.75;
        gbRight.fill = GridBagConstraints.BOTH;
        gbRight.insets = new Insets(5, 5, 1, 5);
        rightPlate.add(rightUpper, gbRight);
        
        gbRight.gridx = 0;
        gbRight.gridy = 1;
        gbRight.gridheight = 1;
        gbRight.gridwidth = 1;
        gbRight.weightx = 1;
        gbRight.weighty = 0.25;
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
        gbRightT.insets = new Insets(7, 7, 2, 7);
        rightUpper.add(checkOutPlate, gbRightT);
        
        gbRightT.gridx = 1;
        gbRightT.gridy = 0;
        gbRightT.gridheight = 1;
        gbRightT.gridwidth = 1;
        gbRightT.weightx = 1;
        gbRightT.weighty = 1;
        gbRightT.fill = GridBagConstraints.BOTH;
        gbRightT.insets = new Insets(7, 7, 2, 7);
        rightUpper.add(accountPlate, gbRightT);
        
        gbRightT.gridx = 2;
        gbRightT.gridy = 0;
        gbRightT.gridheight = 1;
        gbRightT.gridwidth = 1;
        gbRightT.weightx = 1;
        gbRightT.weighty = 1;
        gbRightT.fill = GridBagConstraints.BOTH;
        gbRightT.insets = new Insets(7, 7, 2, 7);
        rightUpper.add(promotionPlate, gbRightT);
        
        gbRightT.gridx = 0;
        gbRightT.gridy = 1;
        gbRightT.gridheight = 1;
        gbRightT.gridwidth = 1;
        gbRightT.weightx = 1;
        gbRightT.weighty = 1;
        gbRightT.fill = GridBagConstraints.BOTH;
        gbRightT.insets = new Insets(7, 7, 7, 7);
        rightUpper.add(stockPlate, gbRightT);
        
        gbRightT.gridx = 1;
        gbRightT.gridy = 1;
        gbRightT.gridheight = 1;
        gbRightT.gridwidth = 1;
        gbRightT.weightx = 1;
        gbRightT.weighty = 1;
        gbRightT.fill = GridBagConstraints.BOTH;
        gbRightT.insets = new Insets(7, 7, 7, 7);
        rightUpper.add(listPlate, gbRightT);
        
        gbRightT.gridx = 2;
        gbRightT.gridy = 1;
        gbRightT.gridheight = 1;
        gbRightT.gridwidth = 1;
        gbRightT.weightx = 1;
        gbRightT.weighty = 1;
        gbRightT.fill = GridBagConstraints.BOTH;
        gbRightT.insets = new Insets(7, 7, 7, 7);
        rightUpper.add(blank7, gbRightT);
        
        //set bottom right
        GridBagConstraints gbRightB = new GridBagConstraints();
        
        gbRightB.gridx = 0;
        gbRightB.gridy = 0;
        gbRightB.gridheight = 1;
        gbRightB.gridwidth = 1;
        gbRightB.weightx = 0.8;
        gbRightB.weighty = 1;
        gbRightB.fill = GridBagConstraints.BOTH;
        gbRightB.insets = new Insets(5, 5, 5, 5);
        rightUnder.add(blank8, gbRightB);
        
        gbRightB.gridx = 1;
        gbRightB.gridy = 0;
        gbRightB.gridheight = 1;
        gbRightB.gridwidth = 1;
        gbRightB.weightx = 0.2;
        gbRightB.weighty = 1;
        gbRightB.fill = GridBagConstraints.BOTH;
        gbRightB.insets = new Insets(5, 5, 5, 5);
        rightUnder.add(flagPlate, gbRightB);
        
        //place image
        GridBagConstraints checkoutGB = new GridBagConstraints();
        
        checkoutGB.gridx = 0;
        checkoutGB.gridy = 0;
        checkoutGB.gridheight = 1;
        checkoutGB.gridwidth = 1;
        checkoutGB.weightx = 1;
        checkoutGB.weighty = 1;
        checkoutGB.fill = GridBagConstraints.VERTICAL;
        checkoutGB.insets = new Insets(5, 5, 5, 5);
        checkOutPlate.add(checkOutLabel, checkoutGB);
        checkOutLabel.setIcon(new ImageIcon(imgCheckOut.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH)));

        checkoutGB.gridy = 1;
        checkoutGB.weighty = 0;
        checkoutGB.fill = GridBagConstraints.VERTICAL;
        checkOutPlate.add(checkOutBttn, checkoutGB);
        
        GridBagConstraints accountGB = new GridBagConstraints();
        
        accountGB.gridx = 0;
        accountGB.gridy = 0;
        accountGB.gridheight = 1;
        accountGB.gridwidth = 1;
        accountGB.weightx = 1;
        accountGB.weighty = 0.8;
        accountGB.fill = GridBagConstraints.VERTICAL;
        accountGB.insets = new Insets(5, 5, 5, 5);
        accountPlate.add(accountLabel, accountGB);
        accountLabel.setIcon(new ImageIcon(imgAccount.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH)));
        
        accountGB.gridx = 0;
        accountGB.gridy = 1;
        accountGB.gridheight = 1;
        accountGB.gridwidth = 1;
        accountGB.weightx = 1;
        accountGB.weighty = 0.2;
        accountGB.fill = GridBagConstraints.VERTICAL;
        accountGB.insets = new Insets(5, 5, 5, 5);
        accountPlate.add(accountBttn, accountGB);

        GridBagConstraints promotionGB = new GridBagConstraints();
        
        promotionGB.gridx = 0;
        promotionGB.gridy = 0;
        promotionGB.gridheight = 1;
        promotionGB.gridwidth = 1;
        promotionGB.weightx = 1;
        promotionGB.weighty = 0.8;
        promotionGB.fill = GridBagConstraints.VERTICAL;
        promotionGB.insets = new Insets(5, 5, 5, 5);
        promotionPlate.add(promotionLabel, promotionGB);
        promotionLabel.setIcon(new ImageIcon(imgPromotion.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH)));
        
        promotionGB.gridx = 0;
        promotionGB.gridy = 1;
        promotionGB.gridheight = 1;
        promotionGB.gridwidth = 1;
        promotionGB.weightx = 1;
        promotionGB.weighty = 0.2;
        promotionGB.fill = GridBagConstraints.VERTICAL;
        promotionGB.insets = new Insets(5, 5, 5, 5);
        promotionPlate.add(promotionBttn, promotionGB);

        GridBagConstraints stockGB = new GridBagConstraints();
        
        stockGB.gridx = 0;
        stockGB.gridy = 0;
        stockGB.gridheight = 1;
        stockGB.gridwidth = 1;
        stockGB.weightx = 1;
        stockGB.weighty = 0.8;
        stockGB.fill = GridBagConstraints.VERTICAL;
        stockGB.insets = new Insets(5, 5, 5, 5);
        stockPlate.add(stockLabel, stockGB);
        stockLabel.setIcon(new ImageIcon(imgStock.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH)));
        
        stockGB.gridx = 0;
        stockGB.gridy = 1;
        stockGB.gridheight = 1;
        stockGB.gridwidth = 1;
        stockGB.weightx = 1;
        stockGB.weighty = 0.2;
        stockGB.fill = GridBagConstraints.VERTICAL;
        stockGB.insets = new Insets(5, 5, 5, 5);
        stockPlate.add(stockBttn, stockGB);
        
        GridBagConstraints listGB = new GridBagConstraints();
        
        listGB.gridx = 0;
        listGB.gridy = 0;
        listGB.gridheight = 1;
        listGB.gridwidth = 1;
        listGB.weightx = 1;
        listGB.weighty = 0.8;
        listGB.fill = GridBagConstraints.VERTICAL;
        listGB.insets = new Insets(5, 5, 5, 5);
        listPlate.add(listLabel, listGB);
        listLabel.setIcon(new ImageIcon(imgList.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH)));
        
        listGB.gridx = 0;
        listGB.gridy = 1;
        listGB.gridheight = 1;
        listGB.gridwidth = 1;
        listGB.weightx = 1;
        listGB.weighty = 0.2;
        listGB.fill = GridBagConstraints.VERTICAL;
        listGB.insets = new Insets(5, 5, 5, 5);
        listPlate.add(listBttn, listGB);
        
        GridBagConstraints flagGB = new GridBagConstraints();
        
        flagGB.gridx = 0;
        flagGB.gridy = 0;
        flagGB.gridheight = 1;
        flagGB.gridwidth = 1;
        flagGB.weightx = 1;
        flagGB.weighty = 0.8;
        flagGB.fill = GridBagConstraints.VERTICAL;
        flagGB.insets = new Insets(5, 5, 5, 5);
        flagPlate.add(flagLabel, flagGB);
        flagLabel.setIcon(new ImageIcon(imgFlag.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH)));
        
        
//        flagPlate.add(flagLabel);
//        flagLabel.setIcon(imgFlag);
        
        //set color or other attribute in frame
        nameBG.setPreferredSize(new Dimension(50, 7));
        profilePalte.setPreferredSize(new Dimension(50, 50));
        profilePalte.setBackground(new Color(180, 130, 120));
        blank1.setBackground(new Color(200, 150, 140));
        checkOutPlate.setBackground(new Color(200, 150, 140));
        accountPlate.setBackground(new Color(200, 150, 140));
        promotionPlate.setBackground(new Color(200, 150, 140));
        stockPlate.setBackground(new Color(200, 150, 140));
        listPlate.setBackground(new Color(200, 150, 140));
        blank7.setBackground(new Color(200, 150, 140));
        blank8.setBackground(new Color(200, 150, 140));
        
        checkOutPlate.setPreferredSize(new Dimension(30, 70));
        accountPlate.setPreferredSize(new Dimension(30, 70));
        promotionPlate.setPreferredSize(new Dimension(30, 70));
        stockPlate.setPreferredSize(new Dimension(30, 70));
        listPlate.setPreferredSize(new Dimension(30, 70));

        flagPlate.setBackground(new Color(200, 150, 140));
        flagPlate.setPreferredSize(new Dimension(20, 30));
        
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
