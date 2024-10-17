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
    public JPanel panel4;
    public JPanel panel5;
    
    public Notification(){
        frame = new JFrame("Restock Notification");
        panel1 = new JPanel();
        panel2 = new JPanel();
        panel3 = new RoundedPanel();
        panel4 = new JPanel();
        panel5 = new JPanel();
        restockLabel = new JLabel("Need to restock into shelf");
        iconBtn = new JLabel();
        okayBtn = new RoundedButton("Okay",20,20);
        textArea = new JTextArea();
        
        
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        
        panel1.setLayout(new BorderLayout());
        
        panel4.setLayout(new FlowLayout(FlowLayout.CENTER));
        panel4.setBackground(new Color(184, 169, 141));
        panel5.setBackground(new Color(184, 169, 141));
        panel5.setLayout(new FlowLayout(FlowLayout.RIGHT, 50,5));
        
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
        panel4.add(restockLabel);
        
        panel5.add(okayBtn);
        panel5.add(iconBtn);

        
        GridBagConstraints gb = new GridBagConstraints();

// Center the label text
gb.gridx = 0;
gb.gridy = 0;
gb.weightx = 1.0;  // Allow the label to expand horizontally
gb.weighty = 1.0;  // Allow the label to expand vertically
gb.gridwidth = 2;  // Span two columns to center the label
gb.gridheight = 1;
gb.fill = GridBagConstraints.HORIZONTAL;  // Allow label to grow horizontally
gb.insets = new Insets(5, 5, 5, 5);  // Padding around the label
gb.anchor = GridBagConstraints.CENTER;  // Center the label horizontally
panel2.add(panel4, gb);

// Adjust the "Okay" button (centered at the bottom)
gb.gridy = 1;  // Move to the next row
gb.gridx = 1;  // First column for the "Okay" button
gb.weightx = 0.5;  // Allow the button to expand horizontally
gb.gridwidth = 1;  // Button takes one column
gb.gridheight = 1;
gb.fill = GridBagConstraints.NONE;  // Do not expand the button
gb.anchor = GridBagConstraints.CENTER;  // Center the button horizontally
gb.insets = new Insets(5, 5, 5, 2);  // Reduce gap between button and icon (right side)
panel2.add(panel5, gb);

//// Place the icon next to the "Okay" button
//gb.gridx = 1;  // Second column for the icon
//gb.weightx = 0.0;  // No horizontal expansion for the icon
//gb.gridwidth = 1;  // Icon takes one column
//gb.gridheight = 1;
//gb.fill = GridBagConstraints.NONE;  // Do not expand the icon
//gb.anchor = GridBagConstraints.CENTER;  // Center the icon vertically
//gb.insets = new Insets(5, 2, 5, 5);  // Minimal space on both sides (left to button and right)
//panel2.add(iconBtn, gb);






                
        
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
