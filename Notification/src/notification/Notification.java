package notification;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;



public class Notification {
    public JFrame frame;
    public JPanel panel1;
    public JPanel panel2;
    public JLabel restockLabel;
    public JLabel iconBtn;
    public JButton okayBtn;
    public JTextArea textArea;
    
    public Notification(){
        frame = new JFrame("Restock Notification");
        panel1 = new JPanel();
        panel2 = new JPanel();
        restockLabel = new JLabel("Need to restock into shelf");
        iconBtn = new JLabel();
        okayBtn = new JButton("Okay");
        textArea = new JTextArea();
        
        
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        
        panel1.setLayout(new BorderLayout());
        
        textArea.setEditable(false);  // Set text area to non-editable
        textArea.setBackground(Color.WHITE);  // Set background to gray
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        panel1.add(textArea, BorderLayout.CENTER);
        panel1.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panel1.setPreferredSize(new Dimension(400, 150));
        panel1.setBackground(new Color(184, 169, 141));
        
        panel2.setLayout(null);
        panel2.setPreferredSize(new Dimension(400, 150));
        panel2.setBackground(new Color(184, 169, 141));
        
        restockLabel.setBounds(130, 40, 200, 25);
        panel2.add(restockLabel);
        
        
        okayBtn.setBounds(150, 70, 100, 40);
        okayBtn.setBackground(new Color(159, 214, 132));
        
        okayBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Done");
                
            }
        });
        panel2.add(okayBtn);
        
        ImageIcon icon = new ImageIcon("C:\\Users\\SUGUS\\Desktop\\WORK\\Downloads\\iCon.png");
        iconBtn = new JLabel(icon);
        iconBtn.setBounds(270, 70, 50, 50);
        panel2.add(iconBtn);
        
        frame.add(panel1, BorderLayout.CENTER);
        frame.add(panel2, BorderLayout.SOUTH);
        frame.setVisible(true);
        
    }
    
    
    
    public static void main(String[] args) {
        new Notification();
    }
    
}
