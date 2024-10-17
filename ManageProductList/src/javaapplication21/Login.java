import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
public class Login {
    public JFrame frame;
    public Login() {
        displayLoginPage();
    }
    public void displayLoginPage(){
        // Create main frame
        JFrame frame = new JFrame("Login");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // create JPanel for laying other elements
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(10, 10, 10, 10);

        // create circle icon for user avatar
        JLabel iconLabel = new JLabel();
        iconLabel.setIcon(new ImageIcon(new ImageIcon("icon.png").getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH)));
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 2;
        panel.add(iconLabel, constraints);

        // create field for enter username
        JLabel userLabel = new JLabel("Username:");
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        panel.add(userLabel, constraints);

        JTextField userText = new JTextField(15);
        constraints.gridx = 1;
        panel.add(userText, constraints);

        // create field for enter password
        JLabel passwordLabel = new JLabel("Password:");
        constraints.gridx = 0;
        constraints.gridy = 2;
        panel.add(passwordLabel, constraints);

        JPasswordField passwordText = new JPasswordField(15);
        constraints.gridx = 1;
        panel.add(passwordText, constraints);

        // create login button
        JButton loginButton = new JButton("Login");
        constraints.gridx = 0;
        constraints.gridy = 3;
        constraints.gridwidth = 2;
        panel.add(loginButton, constraints);
        
                // create new JPanel
        JPanel newPanel = new JPanel();
        newPanel.add(new JLabel("Welcome! You have successfully logged in."));
        
        // add event listener to Login button
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = userText.getText();
                String password = new String(passwordText.getPassword());
                // remove all content in frame and add new JPanel
                if (username.equals("admin") && password.equals("1234")) {
                    // ล็อกอินสำเร็จ
                    JOptionPane.showMessageDialog(frame, "Login Successful!", "Success", JOptionPane.INFORMATION_MESSAGE);

                    // สร้าง JPanel สำหรับหน้าอื่น (หลังจาก Login สำเร็จ)
                    JPanel newPanel = new JPanel();
                    newPanel.add(new JLabel("Welcome! You have successfully logged in."));
                    
                    frame.getContentPane().removeAll();
                    frame.add(newPanel);
                    frame.revalidate();
                    frame.repaint();
                } else {
                    // แจ้งเตือนข้อผิดพลาด
                    displayErrorMessage("Error");
                }
            }
        });

        // add JPanel to JFrame
        frame.add(panel, BorderLayout.CENTER);

        // make frame display
        frame.setVisible(true);
    }
    public void displayDashboard(){
        
    }
//    public void displayProductList(Product productList){
//        
//    }
//    public void displayProductDetails(Product product){
//        
//    }
    public void displayErrorMessage(String message){
        System.out.println(message);
        JOptionPane.showMessageDialog(frame, "Invalid Username or Password!", "Error", JOptionPane.ERROR_MESSAGE);
    }
}
