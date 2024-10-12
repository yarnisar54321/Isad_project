import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditPromotion {
    private JFrame editFrame;
    private JPanel textPlate, editPlate, buttonPlate;
    private JPanel promoBlog, textBlog;
    private JPanel buttonBlog;
    
    private JLabel header;
    private JTextField nameField;
    private JTextArea describeText;
    private JButton cancleButton, doneButton;
    
    private String promoName;
    private String promoDetails;
    
    private EditPromotion(){
        editFrame = new JFrame("promotion Editor");
        textPlate = new JPanel(new FlowLayout(FlowLayout.CENTER));
        editPlate = new JPanel(new GridBagLayout());
        buttonPlate = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 7));
        promoBlog = new JPanel();
        textBlog = new JPanel(new GridBagLayout());
        
        header = new JLabel("Edit");
        header.setFont(new Font("Comic Sans MS", 1, 24));
        
        nameField = new JTextField("name");
        describeText = new JTextArea("description", 10, 30);
        cancleButton = new JButton("Cancle");
        doneButton = new JButton("Done");
        
        cancleButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                /*event*/
            }
            
        });
        
        doneButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                /*event*/
            }
            
        });
        
        editFrame.setLayout(new BorderLayout());
        editFrame.add(textPlate, BorderLayout.NORTH);
        editFrame.add(editPlate, BorderLayout.CENTER);
        editFrame.add(buttonPlate, BorderLayout.SOUTH);
        
        textPlate.add(header);
        
        GridBagConstraints gb_plate = new GridBagConstraints();
        gb_plate.gridx = 0;
        gb_plate.gridy = 0;
        gb_plate.gridheight = 1;
        gb_plate.gridwidth = 1;
        gb_plate.weightx = 0.6;
        gb_plate.weighty = 1;
        gb_plate.fill = GridBagConstraints.BOTH;
        gb_plate.insets = new Insets(20, 10, 10, 10);
        editPlate.add(promoBlog, gb_plate);
        
        promoBlog.setBackground(new Color(250, 210, 208));
        
        gb_plate.gridx = 1;
        gb_plate.gridy = 0;
        gb_plate.gridwidth = 1;
        gb_plate.weightx = 0.4;
        gb_plate.weighty = 1;
        gb_plate.fill = GridBagConstraints.BOTH;
        gb_plate.insets = new Insets(20, 10, 10, 10);
        editPlate.add(textBlog, gb_plate);
        
        GridBagConstraints gb_txt = new GridBagConstraints();
        
        gb_txt.gridx = 0;
        gb_txt.gridy = 0;
        gb_txt.gridheight = 1;
        gb_txt.gridwidth = 3;
        gb_txt.weightx = 1;
        gb_txt.weighty = 0.1;
        gb_txt.fill = GridBagConstraints.HORIZONTAL;
        gb_txt.insets = new Insets(10, 10, 10, 10);
        textBlog.add(nameField, gb_txt);
        
        gb_txt.gridx = 0;
        gb_txt.gridy = 1;
        gb_txt.gridheight = 2;
        gb_txt.weightx = 1;
        gb_txt.weighty = 1;
        gb_txt.insets = new Insets(10, 10, 10, 10);
        textBlog.add(new JScrollPane(describeText), gb_txt);
        
        buttonPlate.add(cancleButton);
        buttonPlate.add(doneButton);
        
        editFrame.setResizable(false);
        editFrame.setSize(750, 400);
        editFrame.setVisible(true);
        editFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public static void main(String[] args) {
        new EditPromotion();
    }
}
