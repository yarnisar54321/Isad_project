package javaapplication21;

import java.awt.*;
import java.awt.geom.RoundRectangle2D;
import javax.swing.*;

public class RoundedButton extends JButton{
    private int arcWidth = 20;
    private int arcHieght = 20;
    
    public RoundedButton(String text, int arcWidth, int arcHieght){
        super(text);
        this.arcHieght = arcHieght;
        this.arcWidth = arcWidth;
        setContentAreaFilled(false);
        setFocusPainted(false);
        setBorderPainted(false);
    }
    
    public RoundedButton(String text){
        super(text);
        setContentAreaFilled(false);
        setFocusPainted(false);
        setBorderPainted(false);
    }
    
    public RoundedButton(int arcWidth, int arcHieght){
        super("");
        this.arcHieght = arcHieght;
        this.arcWidth = arcWidth;
        setContentAreaFilled(false);
        setFocusPainted(false);
        setBorderPainted(false);
    }
    
    public RoundedButton(){
        super("");
        setContentAreaFilled(false);
        setFocusPainted(false);
        setBorderPainted(false);
    }
    
    @Override
    protected void paintComponent(Graphics g){
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        int width = getWidth();
        int height = getHeight();
        
        RoundRectangle2D roundedRectangle = new RoundRectangle2D.Float(0, 0, width, height, arcWidth, arcHieght);
        
        g2d.setColor(getBackground());
        g2d.fill(roundedRectangle);
        
        super.paintComponent(g);
        
        g2d.dispose();
    }
}
