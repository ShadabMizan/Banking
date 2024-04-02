package BankApp;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import Logic.ClientAccount;

public class ClientPanel extends ContentPanel implements OkButtonListener
{
	private static final long serialVersionUID = -2853494268694350269L;
	
	private JPanel clientBody = new JPanel(new FlowLayout());

	public ClientPanel()
	{
		// Panel Styles
        this.setBorder(BorderFactory.createEmptyBorder(16, 16, 16, 16)); // Add 16 pixels of padding around the panel
		this.setBackground(Color.white);
		this.setLayout(new BorderLayout());
		
		// Client Panel will have a min Width of 1176px. 
		// Again, 800px becomes meaningless as it will be bounded EAST
		this.setPreferredSize(new Dimension(1176, 800));
		
        JLabel clientTitle = new JLabel("Clients");
        clientTitle.setFont(super.retrieveFont().deriveFont(Font.PLAIN, 32));       
        clientTitle.setVerticalAlignment(JLabel.TOP);
        clientTitle.setHorizontalAlignment(JLabel.CENTER);
        
        clientBody.setBackground(getBackground());
        this.add(clientTitle, BorderLayout.NORTH);
        this.add(clientBody, BorderLayout.CENTER);
	}

	@Override
	public void getNewAccount(ClientAccount account) 
	{
	    SwingUtilities.invokeLater(() -> {
			displayNewAccount(account);
	    });
	}
	
	private void displayNewAccount(ClientAccount account) 
	{
		String labelText = "<html><center>" + account.getName() + "<br>" + account.getID() + "</center></html>";
		JLabel label = new JLabel(labelText);
		label.setHorizontalAlignment(SwingConstants.CENTER); // Center horizontally
		label.setVerticalAlignment(SwingConstants.CENTER); // Center vertically
		
		label.setPreferredSize(new Dimension(100, 50));
		label.setBackground(primaryColour);
		label.setOpaque(true);
		label.setFont(super.retrieveFont().deriveFont(Font.PLAIN, 16));
		label.setForeground(Color.white);
		clientBody.add(label);
		
		clientBody.revalidate();
		clientBody.repaint();
	}
}
