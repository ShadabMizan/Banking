package BankApp;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JButton;

public class CircularButton extends JButton 
{
	private static final long serialVersionUID = 1610673966822667968L;
	private int buttonRadius;
	
	CircularButton(String label, int radius) 
	{
        super(label);
        this.buttonRadius = radius;
        
        // Button should not paint its background
        setContentAreaFilled(false);
        
        // Button should not focus
        setFocusPainted(false); 
    }
	
    @Override
    protected void paintComponent(Graphics g) 
    {
        if (getModel().isArmed()) 
        {
            g.setColor(new Color(0x8157FA));
        } else 
        {
            g.setColor(getBackground());
        }
        
        g.fillOval(0, 0, getSize().width - 1, getSize().height - 1);
        super.paintComponent(g);
    }

    @Override
    protected void paintBorder(Graphics g){} // Nothing to not draw a border

    @Override
    public Dimension getPreferredSize() { return new Dimension(buttonRadius, buttonRadius); }
}

