package BankApp;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Main 
{
	public static void main(String[] args) 
	{
		// Instantiate each panel
		ClientPanel clientPanel = new ClientPanel();
		InteractionPanel interactionPanel = new InteractionPanel();
		
		ActionButtonListener[] actionSubscribers = {clientPanel, interactionPanel};
		
		ActionPanel actionPanel = new ActionPanel(actionSubscribers);
		
		
		JFrame frame = new JFrame();
		// Window Settings
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800,600);
//		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setLayout(new BorderLayout());
		frame.setVisible(true);
		
        // Add the Panels at their corresponding locations
        frame.add(actionPanel, BorderLayout.WEST);
        frame.add(clientPanel, BorderLayout.CENTER);
        frame.add(interactionPanel, BorderLayout.SOUTH);
        
//        frame.pack();
//        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
	}
}
