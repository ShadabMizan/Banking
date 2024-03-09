package BankApp;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ClientPanel extends ContentPanel
{
	private static final long serialVersionUID = -2853494268694350269L;

	ClientPanel()
	{
		// Panel Styles
        this.setBorder(BorderFactory.createEmptyBorder(16, 16, 16, 16)); // Add 16 pixels of padding around the panel
        this.setLayout(new BorderLayout(56,48));
		this.setBackground(Color.white);
		
		// Client Panel will have a min Width of 1176px. 
		// Again, 800px becomes meaningless as it will be bounded EAST
		this.setPreferredSize(new Dimension(1176, 800));
		
        JLabel clientTitle = new JLabel("Clients");
        clientTitle.setFont(super.retrieveFont().deriveFont(Font.PLAIN, 32));
        
        // Attempted to make Client Title location dynamic, next time :(.
        JPanel titlePanel = new JPanel(new BorderLayout());
        titlePanel.setBackground(Color.WHITE);
        titlePanel.add(clientTitle, BorderLayout.NORTH);
        
        clientTitle.setVerticalAlignment(JLabel.TOP);
        clientTitle.setHorizontalAlignment(JLabel.CENTER);
        
        this.add(titlePanel, BorderLayout.CENTER);
	}
}
