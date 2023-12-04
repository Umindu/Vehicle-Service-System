/*
 *  Jangan lupa SUBSCRIBE https://www.youtube.com/@FOSALGO/videos
 *  Tetap Semangat...!!! Semua orang Bisa Belajar Coding
 *  Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package CustomComponents;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.BorderFactory;
import javax.swing.JPasswordField;

/**
 *
 * @author FOSALGO
 */
public class FTPasswordextField extends JPasswordField{
    private Color fillColor;
    private Color lineColor;
    private int strokeWidth;
    private int radius = 0;
       
    public FTPasswordextField() {
        fillColor = new Color(236, 240, 241);
        lineColor = new Color(13,180,185);
        strokeWidth = 1;
        setOpaque(false);
        setBorder(BorderFactory.createEmptyBorder(2, 10, 2, 10));
    }

    public Color getFillColor() {
        return fillColor;
    }

    public void setFillColor(Color fillColor) {
        this.fillColor = fillColor;
    }

    public Color getLineColor() {
        return lineColor;
    }

    public void setLineColor(Color lineColor) {
        this.lineColor = lineColor;
    }

    public int getStrokeWidth() {
        return strokeWidth;
    }

    public void setStrokeWidth(int strokeWidth) {
        this.strokeWidth = strokeWidth;
    }
    
    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }
    
    
    
    @Override
    protected void paintComponent(Graphics g) {
        if (!isOpaque()) {            
            Graphics2D g2d = (Graphics2D) g;
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            int s = strokeWidth;
            int w = getWidth() - (2 * s);
            int h = getHeight() - (2 * s);
            g2d.setColor(fillColor);
            g2d.fillRoundRect(s, s, w, h, radius, radius);
            g2d.setStroke(new BasicStroke(s));
            g2d.setColor(lineColor);
            g2d.drawRoundRect(s, s, w, h, radius, radius);
        }
        super.paintComponent(g);        
    }
    
}