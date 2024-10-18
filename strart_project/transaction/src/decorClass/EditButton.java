package decorClass;


import decorClass.RoundedButton;
import javax.swing.JPanel;

/**
 *
 * @author DELL
 */
public class EditButton extends RoundedButton{
    JPanel cleanPlate;
    
    public EditButton(){
        this.setText("edit");
        this.setFont(new java.awt.Font("Comic Sans MS", 1, 16));
        cleanPlate = new JPanel();
        cleanPlate.setBackground(null);
        cleanPlate.add(this);
        cleanPlate.setSize(60, 50);
    }
}
