/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package decorClass;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

public class RoundedPanel extends JPanel {

    private int arcWidth;
    private int arcHeight;

    public RoundedPanel(int arcWidth, int arcHeight, LayoutManager layout) {
        this.arcWidth = arcWidth;
        this.arcHeight = arcHeight;
        setLayout(layout);
        setOpaque(false);
    }
    
    public RoundedPanel(int arcWidth, int arcHeight) {
        this.arcWidth = arcWidth;
        this.arcHeight = arcHeight;
        setLayout(new FlowLayout());
        setOpaque(false);
    }
    
    public RoundedPanel(LayoutManager layout) {
        this(20, 20);
        setLayout(layout);
        setOpaque(false);
    }
    
    public RoundedPanel() {
        this(20, 20);
        setLayout(new FlowLayout());
        setOpaque(false);
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int width = getWidth();
        int height = getHeight();

        RoundRectangle2D roundedRectangle = new RoundRectangle2D.Float(0, 0, width, height, arcWidth, arcHeight);

        g2d.setColor(getBackground());
        g2d.fill(roundedRectangle);

        super.paintComponent(g);

        g2d.dispose();
    }
}