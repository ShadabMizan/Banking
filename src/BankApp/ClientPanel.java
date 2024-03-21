package BankApp;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JLabel;

public class ClientPanel extends ContentPanel implements ActionButtonListener
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
        clientTitle.setVerticalAlignment(JLabel.TOP);
        clientTitle.setHorizontalAlignment(JLabel.CENTER);
        
        this.add(clientTitle);
	}

	@Override
	public void actionClicked() {
		// TODO Auto-generated method stub
		
	}
}
