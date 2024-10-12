import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreatePromotion {
    private JFrame createPromo;
    private JPanel textPlate, detailPlate, buttonPlate, buttonBlog;
    private JPanel fillDetail;
    private JButton cancleB, doneB;
    private JLabel header;
    private JTextField namePromo;
    private JTextArea describePromo;
    
    private String promoName;
    private String promoDetails;
    
    private CreatePromotion(){
        createPromo = new JFrame("Create new Promotion");
        textPlate = new JPanel(new FlowLayout(FlowLayout.CENTER));
        detailPlate = new JPanel(new FlowLayout(FlowLayout.CENTER));
        fillDetail = new JPanel(new GridBagLayout());
        buttonPlate = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttonBlog = new JPanel();
        cancleB = new JButton("Cancle");
        doneB = new JButton("Done");
        header = new JLabel("Create Promotion");
        namePromo = new JTextField("name");
        describePromo = new JTextArea("Description", 10, 40);
        
        cancleB.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                /*event*/
            }
            
        });
        
        doneB.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                /*event*/
            }
            
        });
        
        GridBagConstraints gb = new GridBagConstraints();
        
        gb.gridx = 0;
        gb.gridy = 0;
        gb.gridheight = 1;
        gb.gridwidth = 3;
        gb.weightx = 1;
        gb.weighty = 0.1;
        gb.fill = GridBagConstraints.HORIZONTAL;
        gb.insets = new Insets(40, 10, 10, 10);
        fillDetail.add(namePromo, gb);
        
        gb.gridx = 0;
        gb.gridy = 1;
        gb.gridheight = 2;
        gb.weightx = 1;
        gb.weighty = 1;
        gb.insets = new Insets(10, 10, 10, 10);
        fillDetail.add(new JScrollPane(describePromo), gb);
        
        detailPlate.add(fillDetail);
        
        createPromo.setLayout(new BorderLayout());
        buttonBlog.setLayout(new FlowLayout(FlowLayout.RIGHT, 20, 7));
        createPromo.add(textPlate, BorderLayout.NORTH);
        createPromo.add(detailPlate, BorderLayout.CENTER);
        createPromo.add(buttonPlate, BorderLayout.SOUTH);
        buttonBlog.add(cancleB);
        buttonBlog.add(doneB);
        buttonPlate.add(buttonBlog);
        textPlate.add(header);
        
        header.setFont(new Font("Comic Sans MS", 1, 24));
        
        
        createPromo.setSize(750, 400);
        createPromo.setVisible(true);
        createPromo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public static void main(String[] args) {
        new CreatePromotion();
    }
}
