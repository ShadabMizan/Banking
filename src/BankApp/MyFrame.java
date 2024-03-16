package BankApp;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class MyFrame extends JFrame 
{
	private static final long serialVersionUID = 1535989389304658012L;

	MyFrame()
	{
		// Instantiate each panel
		ActionPanel actionPanel = new ActionPanel();
		ClientPanel clientPanel = new ClientPanel();
		InteractionPanel interactionPanel = new InteractionPanel();
		
		// Window Settings
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(800,600);
//		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setLayout(new BorderLayout());
		this.setVisible(true);
		
        // Add the Panels at their corresponding locations
        this.add(actionPanel, BorderLayout.WEST);
        this.add(clientPanel, BorderLayout.CENTER);
        this.add(interactionPanel, BorderLayout.SOUTH);
	}
}
