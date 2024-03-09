package BankApp;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JLabel;

public class InteractionPanel extends ContentPanel
{
	private static final long serialVersionUID = -8965688801455558536L;
	
	InteractionPanel()
	{
		// Panel Styles
        this.setBorder(BorderFactory.createEmptyBorder(16, 16, 16, 16)); // Add 16 pixels of padding around the panel
        this.setLayout(new BorderLayout(24,24)); // Add 24 pixels of inner paddings
        this.setBackground(new Color(0x222026));
        
        // Interaction Panel will have 1440px width and 200px height. 
        // Height will not scale, since Bounded SOUTH
        this.setPreferredSize(new Dimension(1440, 200)); 
        
        // Title Styles
        JLabel interactionTitle = new JLabel("Interactions");
        interactionTitle.setVerticalAlignment(JLabel.TOP);
        interactionTitle.setHorizontalAlignment(JLabel.CENTER);
        interactionTitle.setFont(super.retrieveFont().deriveFont(Font.PLAIN, 32)); //32px Font size
        interactionTitle.setForeground(Color.white);
        
        // Add Components to Panel
        this.add(interactionTitle);
	}
}
