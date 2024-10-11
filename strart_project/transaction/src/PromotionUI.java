import MainSWM.NewJFrame;
import javax.swing.JFrame;
import decorClass.CircleButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class PromotionUI {
    private CircleButton addButton;
    private JFrame promoFrame;
    private JPanel promoPlate;
    private JScrollPane promoScroller;
    private JLabel promoText;
    
    private PromotionUI(){
        promoFrame = new JFrame();
        promoPlate = new JPanel();
        promoScroller = new JScrollPane();
        addButton = new CircleButton();
        promoText = new JLabel("Promotion");
        
        promoFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        promoFrame.setVisible(true);
        promoText.setFont(new Font("Comic Sans MS", 1, 24));
        addButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent event){
                addButtonActionPerformed(event);
            }

            private void addButtonActionPerformed(ActionEvent event) {
                throw new UnsupportedOperationException("Not supported yet.");
            }
        });
        
        promoFrame.add(promoPlate);
        promoFrame.pack();
        
        javax.swing.GroupLayout promoPlateLayout = new javax.swing.GroupLayout(promoPlate);
        promoPlate.setLayout(promoPlateLayout);
        
        promoPlateLayout.setHorizontalGroup(
        promoPlateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(promoScroller)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, promoPlateLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
            .addGroup(promoPlateLayout.createSequentialGroup()
                .addGap(15, 15, 15)
            .addComponent(promoText, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(297, Short.MAX_VALUE))
        );
        
        promoPlateLayout.setVerticalGroup(
        promoPlateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(promoPlateLayout.createSequentialGroup()
                .addContainerGap()
            .addComponent(promoText, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
                .addGap(18, 18, 18)
            .addComponent(promoScroller, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );

    }
    
    public static void main(String[] args) {
        new PromotionUI();
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }

}
