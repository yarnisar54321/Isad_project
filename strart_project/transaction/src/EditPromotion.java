import javax.swing.*;
import java.awt.*;

public class EditPromotion {
    private JFrame editFrame;
    private JPanel textPlate, editPlate, buttonPlate;
    private JPanel promoBlog, textBlog;
    private JPanel buttonBlog;
    
    private JLabel header;
    private JTextField nameField;
    private JTextArea describeText;
    private JButton cancleButton, doneButton;
    
    private EditPromotion(){
        editFrame = new JFrame("promotion Editor");
        textPlate = new JPanel(new FlowLayout(FlowLayout.CENTER));
        editPlate = new JPanel(new GridBagLayout());
        buttonPlate = new JPanel(new GridLayout(1, 3));
        promoBlog = new JPanel();
        textBlog = new JPanel(new GridBagLayout());
        buttonBlog = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        
        header = new JLabel("Edit");
        header.setFont(new Font("Comic Sans MS", 1, 24));
        
        nameField = new JTextField("name");
        describeText = new JTextArea("description", 10, 30);
        cancleButton = new JButton("Cancle");
        doneButton = new JButton("Done");
        
        editFrame.setLayout(new BorderLayout());
        editFrame.add(textPlate, BorderLayout.NORTH);
        
        textPlate.add(header);
        
        editFrame.setVisible(true);
        editFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public static void main(String[] args) {
        new EditPromotion();
    }
}
