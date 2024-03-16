package BankApp;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class InteractionPanel extends ContentPanel
{
	private static final long serialVersionUID = -8965688801455558536L;
	
	InteractionPanel()
	{
		// Panel Styles
		int panelPadding = 8;
        this.setBorder(BorderFactory.createEmptyBorder(panelPadding, panelPadding, panelPadding, panelPadding)); // Add 16 pixels of padding around the panel
        this.setLayout(new BorderLayout(8,8)); // Add 8 pixels of inner paddings
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
        
        JPanel titlePanel = new JPanel();
        titlePanel.setLayout(new BorderLayout());
        titlePanel.setBackground(Color.gray);
        titlePanel.add(interactionTitle, BorderLayout.CENTER);
        
        JPanel contents = new JPanel();
        contents.setLayout(new FlowLayout(FlowLayout.RIGHT));
        contents.setBackground(Color.LIGHT_GRAY);
        
        JButton okButton = new JButton();
        okButton.setPreferredSize(new Dimension(50,50));
        contents.add(okButton);
        
        
        // Add Components to Panel
        this.add(titlePanel, BorderLayout.NORTH);
        this.add(contents);
	}
}
