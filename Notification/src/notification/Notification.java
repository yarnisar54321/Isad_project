package notification;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import decorClass.RoundedPanel;
import decorClass.RoundedButton;

public class Notification {
    public JFrame frame;
    public JPanel panel1;
    public JPanel panel2;
    public RoundedPanel panel3;
    public JLabel restockLabel;
    public JLabel iconBtn;
    public RoundedButton okayBtn;
    public JTextArea textArea;
    
    public Notification(){
        frame = new JFrame("Restock Notification");
        panel1 = new JPanel();
        panel2 = new JPanel();
        panel3 = new RoundedPanel();
        restockLabel = new JLabel("Need to restock into shelf");
        iconBtn = new JLabel();
        okayBtn = new RoundedButton("Okay",20,20);
        textArea = new JTextArea();
        
        
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        
        panel1.setLayout(new BorderLayout());
        
        textArea.setEditable(false);  // Set text area to non-editable
        textArea.setBackground(Color.WHITE);  // Set background to gray
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setOpaque(false);
        textArea.setBackground(new Color(0,0,0,0));
        
        panel3.add(textArea);
        panel1.add(panel3, BorderLayout.CENTER);
        panel1.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panel1.setPreferredSize(new Dimension(400, 150));
        panel1.setBackground(new Color(184, 169, 141));
        
        
        panel2.setLayout(new GridBagLayout());
        panel2.setPreferredSize(new Dimension(400, 150));
        panel2.setBackground(new Color(184, 169, 141));
        
        restockLabel.setBounds(150, 30, 200, 25);

        
        GridBagConstraints gb = new GridBagConstraints();
        gb.gridx = 0;
        gb.gridy = 0;
        gb.weightx = 0.6;
        gb.weighty = 1;
        gb.gridwidth = 1;
        gb.gridheight = 1;
        gb.fill = GridBagConstraints.HORIZONTAL;
        gb.insets = new Insets(5,5,5,5);
        panel2.add(restockLabel, gb);
        gb.gridy = 1;
        panel2.add(okayBtn, gb);
        gb.gridx = 1;
        gb.gridy = 0;
        gb.weightx = 0.4;
        gb.gridheight = 2;
        gb.fill = GridBagConstraints.BOTH;
        panel2.add(iconBtn, gb);
                
        
        okayBtn.setBounds(150, 70, 100, 40);
        okayBtn.setBackground(new Color(159, 214, 132));
        
        okayBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Done");
                
            }
        });
        
        
        
        ImageIcon icon = new ImageIcon("C:\\Users\\SUGUS\\Desktop\\WORK\\Downloads\\flag-removebg-preview.png");
        iconBtn.setIcon(icon);
        iconBtn.setBounds(270, 70, 50, 48);
        
        
        frame.add(panel1, BorderLayout.CENTER);
        frame.add(panel2, BorderLayout.SOUTH);
        frame.setVisible(true);
        
    }
    
    
    
    public static void main(String[] args) {
        new Notification();
    }
    
}
